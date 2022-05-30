package Algorithm04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2747 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int[] fivonach = new int[input + 1];
		fivonach[0] = 0;
		fivonach[1] = 1;
		for (int i = 2; i < fivonach.length; i++) {
			fivonach[i] = fivonach[i - 2] + fivonach[i - 1];
		}
		System.out.println(fivonach[input]);
	}
}
