package Algorithm04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int temp = 0;
		int result = 0;
		int order = 0;
		for (int i = 1; i <= 9; i++) {
			temp = Integer.parseInt(br.readLine());
			if (temp > result) {
				result = temp;
				order = i;
			}
		}
		System.out.println(result+"\n"+order);
	}
}