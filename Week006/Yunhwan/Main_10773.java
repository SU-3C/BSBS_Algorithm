package Algorithm06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int value = 0;
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			value = Integer.parseInt(br.readLine());
			if (value == 0) {
				stack.pop();
			} else {
				stack.push(value);
			}
		}
		int sum = 0;
		while (!stack.empty()) {
			sum += stack.pop();
		}
		System.out.println(sum);

	}
}
