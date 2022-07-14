package Algorithm08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1966 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for(int i =0; i<testCase; i++){
			String documentAndTarget = br.readLine();
			StringBuilder sb = new StringBuilder(br.readLine());
			int subtest = documentAndTarget.charAt(0)-'0';
			int[] test = new int[subtest];
			for (int j=0; j<subtest; j++){
				test[j] = Integer.parseInt(br.readLine());

			}
		}


	}
}
