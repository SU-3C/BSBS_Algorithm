package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Factorial {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = fac(N);
		System.out.println(sum);
		
	}
	
	public static int fac(int N) {
		if(N <= 1) return 1;	//스택 오버플로우 막기위한 재귀함수 종료조건
		return N * fac(N - 1);		
	}
 
}
