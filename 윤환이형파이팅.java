import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder("");
		Stack<Integer> stack = new Stack<>();

		// 수열 입력 받는 코드
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> sequence = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			sequence.add(i, Integer.parseInt(br.readLine()));
		} // end of for
			// countNum>수열 값> 스택값
		int count = 1;
		for (int i = 0; i < N; i++) {
			Integer value = sequence.get(i);
			while (true) {
				if (!stack.empty() && stack.peek().equals(value)) {// 스택이 비어있지않고 수열값하고 스택값이 같을 때
					stack.pop();
					result.append("-\n");
					break;
				} else if (!stack.empty() && stack.peek().intValue() > value.intValue()) {// 스택값이 수열값보다 클때
					stack.pop();
					result.append("-\n");
					if (stack.empty()) {
						System.out.println("NO");
						System.exit(0);
					}
				} else {
					stack.push(count);
					result.append("+\n");
					count++;
				}
			} // end while
		} // for
		System.out.println(result);// 끝까지 가면 내가 이긴다....
	}
}