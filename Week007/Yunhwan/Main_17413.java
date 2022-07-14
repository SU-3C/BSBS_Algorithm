package Algorithm07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < sb.length(); i++) {
			char value = sb.charAt(i);

			if (value == '<') {// 태그 처리
				while (!stack.empty()) {// 꺽쇠 앞에 값이 있으면 이전값은 스택에 넣었으니까 스택 출력
					System.out.print(stack.pop());
				}

				System.out.print(value);// 정 꺽쇠 출력
				while (value != '>') {// 역 꺽쇠가 나올때까지
					i++;// i값을 추가해서 다음 문자열값 할당
					value = sb.charAt(i);
					System.out.print(value);// 역꺽쇠까지 출력 후 while조건 검사
				} // end of while
			} // end of if
			else if (value == ' ') {// 공백 단어 처리
				while (!stack.empty()) {//이전 스택에 들어있는 값 출력
					System.out.print(stack.pop());
				}//end of while
				System.out.print(value);
			} // end of else if
			else {
				stack.push(value);// 태그가 아니라면 스택에 추가 (스택에 넣어 뒤집기 위해서)
			} // end of else
		} // end of for
		while (!stack.empty()) {// 스택에 값이 남아있으면 출력
			System.out.print(stack.pop());
		}//end of while
	}// end of main
}
