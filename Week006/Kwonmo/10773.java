package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bak10773 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < K; i++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) 
				stack.pop();
			else stack.push(N);
		}
		
		int sum = 0;
		
		//스택에 저장된 값이 없을때까지 스택에서 하나씩 제외시키면서 sum에 더해준다.
		while(!stack.empty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}

}
