package Algorithm06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12605 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		int testCase = Integer.parseInt(br.readLine());
		for(int i =0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreElements()) {
				stack.push(st.nextToken());
			}
			System.out.printf("Case #%d:",i+1);
			while(!stack.empty()) {
				System.out.print(" "+stack.pop());
			}
			System.out.println();
		}
	}
}
