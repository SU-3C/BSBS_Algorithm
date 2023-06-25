package Algorithm06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			String command = br.readLine();
			StringTokenizer st = new StringTokenizer(command);
			switch (st.nextToken()) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "top":
				if (stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
				break;
			case "empty":
				if (stack.empty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			}
		}
	}
}
