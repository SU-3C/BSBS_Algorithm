package Algorithm02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1712 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		int fixedCostA = Integer.parseInt(st.nextToken());
		int unfixedCostB = Integer.parseInt(st.nextToken());
		int priceC = Integer.parseInt(st.nextToken());

		int income = priceC - unfixedCostB;

		if (income <= 0) {
			System.out.println(-1);
		} else {
			int breakPoint = fixedCostA/income +1;
			System.out.println(breakPoint);
		}
	}
}
