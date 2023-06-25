package Algorithm07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		int totalCount = 0;
		int Tcase = Integer.parseInt(br.readLine());
		String[] TcaseArr = new String[Tcase];
		for (int i = 0; i < Tcase; i++) {
			TcaseArr[i] = br.readLine();

			for (int j = 0; j < TcaseArr[i].length(); j++) {
				char value = TcaseArr[i].charAt(j);
				if (stack.empty()) {// 비어있으면 넣어줘
					stack.push(value);
				} else if (stack.peek() == value) {// 현재 값하고 스택 같으면
					stack.pop();
				} else {
					stack.push(value);
				}
			}//end of inner for
			
			if(stack.empty()) {
				totalCount++;//문자들이 맞아 떨어졌을 때 카운트++
			}else {
				stack.clear();//
			}
		} // end of for
		System.out.println(totalCount);
	}
}
