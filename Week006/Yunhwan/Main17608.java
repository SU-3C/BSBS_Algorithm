package Algorithm06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main17608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		int current = 0;

		for (int i = 0; i < testCase; i++) {
			current = Integer.parseInt(br.readLine());

			// 스택에 값이 없으면
			if (stack.empty()) {
				max = current;
				stack.push(current);
			}
			// 가장 큰 막대기랑 같거나 그것보다 크다면 스택을 비우고 해당 값을 넣어줌
			else if (current >= max) {
				max = current;
				stack.clear();
				stack.push(current);
			}
			//값이 있고 현재 값이 전에 이전 들어있는 값보다 크다면 이전 값을 제거하는 작업 반복하고
			//현재 값을 넣어줌
			else {
				while (current >= stack.peek()) {
					stack.pop();
					if (stack.size() == 0)
						break;
				}
				stack.push(current);
			}
		}//end for
		System.out.println(stack.size());
	}
}
