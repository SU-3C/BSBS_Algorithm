package week6;

import java.util.Scanner;
import java.util.Stack;

public class Bak9012 {
	static Stack<String> stack;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			String input;
			if(i==N-1) {
				input=sc.nextLine();
			}
			
			input=sc.next();
			System.out.println(makeAlgo(input));
		}
	}
	
	public static String makeAlgo(String s) {
		Stack<Character> stack=new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {	// legnth는 문자열의 길이
			char c = s.charAt(i);	// i 번째 문자
			// 여는 괄호일 경우 스택에 넣는다.
			if(c == '(') {
				stack.push(c);
			}
		    /*닫는 괄호일 경우
			  스택이 비어있는 경우. 즉, 닫는 괄호를 입력받았으나 pop할 원소가 없을 경우*/
			else if(stack.empty()){
				return "NO";
			}
			// 그 외의 경우 stack 원소를 pop
			else {
				stack.pop();
			}
		}
		
		if(stack.empty()) {
			return "YES";
		}
		else {
			return "NO";
		}
		/*
		 모든 검사 마치고 스택에 잔여 요소가 있으면 여는 괄호가 많은 경우는 "NO"
		 스택이 비어있으면 온전한 수식이므로 "YES"
		*/
	}
}

