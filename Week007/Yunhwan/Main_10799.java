package Algorithm07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test = br.readLine();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < test.length(); i++) {//스택에 값을 넣고
			if (stack.empty()) {//stack이 EmptyStack에러 대비
				stack.push(test.charAt(i));
				
			}else {
				if (stack.peek() == '(' && test.charAt(i) == ')') {//()(VPS)일 경우 레이저취급
					stack.pop();
					stack.push('|');
				}else {
					stack.push(test.charAt(i));
				}
			}
		}
		int stick = 0;
		int sum = 0;
		while (!stack.empty()) {//컨베이어 밸트 처리과정, 막대사탕 자르기 생각하면 좋음
			char pop = stack.pop();
			if(pop==')') {
				stick++;
			}else if(pop=='|'){//레이저일 경우 현재 카운트된 막대기 개수 만큼 sum 추가 
				sum+=stick;
			}else if(pop=='(') {//막대기의 끝일 경우 카운트에서 제거하고 sum 추가
				stick--;
				sum++;
			}
		}
		System.out.println(sum);
	}
}
