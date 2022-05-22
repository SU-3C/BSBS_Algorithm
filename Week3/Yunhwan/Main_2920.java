package Algorithm03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte[] Melody = new byte[8];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < Melody.length; i++) {
			Melody[i] = Byte.parseByte(st.nextToken());
		}
		// 첫번째 값이 1이면
		if (Melody[0] == 1) {
			for (int i = 1; i < Melody.length; i++) {
				// 앞의 인덱스 요소의 값보다 1 크지 않으면 mixed출력 후 반복문을 빼져나옴
				if (Melody[i] != Melody[i - 1] + 1) {
					System.out.println("mixed");
					System.exit(0);
				}
			} // end for
				// 마지막 요소까지 정상이면
			System.out.println("ascending");
		} // end First IF
			// 첫번째 값이 8이면
		else if (Melody[0] == 8) {
			for (int i = 1; i < Melody.length; i++) {
				// 앞의 인덱스 요소의 값보다 1 작지 않으면 반복문을 빼져나옴
				if (Melody[i] != Melody[i - 1] - 1) {
					System.out.println("mixed");
					System.exit(0);
				}
			} // end for
				// 마지막 요소까지 정상이면
			System.out.println("descending");
		} // end ELSE IF
			//
		else {
			System.out.println("mixed");
		}
	}
}
