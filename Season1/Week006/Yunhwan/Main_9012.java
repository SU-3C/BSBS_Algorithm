package Algorithm06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		int count = 0;
		String result = "";
		int testCase = Integer.parseInt(br.readLine());
		// for문으로 테스트케이스를 입력 받고 해당 스트링의 문자인덱스로 스텍에 넣어줌
		for (int i = 0; i < testCase; i++) {
			String test = br.readLine();
			//스택에 값을 넣어줌
			for (int j = 0; j < test.length(); j++) {
				stack.push(test.charAt(j));
			} // second for
			//만약 스택 맨 윗 값이 정괄호이면 분석하지 않고 NO넣어주고 스택초기화, 넘어가 
			if(stack.peek()=='(') {
				result="NO";
				stack.clear();
			}else {
			// ')'시작이면 분석 시작
				while (!stack.empty()) {//스택에 값이 있다면
					if(stack.pop()==')') {//스택에서 꺼낸 값이 역괄호면 count+1
						count++;
					}else {//역괄호가 아니면 count - 1
						count--;
					}
					if(count<0) {//만약 정괄호가 더 많다면 문자열 뒤에서 
								 //역괄호가 부족한 것이므로 방향불일치라고 판단 NO, 분석 종료
						result="NO";
						break;
					}
				} // end while
				stack.clear();
				if(count==0) {
					result="YES";
				}else {
					result="NO";
				}
			}
			System.out.println(result);
			result="";
			count = 0;
			
		} // first for
	}
}
