package Algorithm04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10872 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		System.out.println(factorial(input));
		
	}
	public static int factorial(int input) {
		if(input==1||input==0)return 1;
		return input*factorial(input-1);
	}
}
