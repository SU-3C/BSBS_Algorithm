package Algorithm02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//(1 ≤ H, W ≤ 99, 1 ≤ N ≤ H × W).

public class Main_10250 {
	public static void main(String[] args) throws IOException {
		// 버퍼리더를 사용하기 위한 br객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		int[] H = new int[testCaseNum];
		int[] W = new int[testCaseNum];
		int[] N = new int[testCaseNum];

		int floor = 0;
		int room = 0;

		// 조건 입력
		for (int i = 0; i < testCaseNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H[i] = Integer.parseInt(st.nextToken());
			W[i] = Integer.parseInt(st.nextToken());
			N[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < testCaseNum; i++) {
			if (N[i] % H[i] == 0) {
				floor = H[i];
				room = N[i] / H[i];
				if (room < 10) {
					System.out.println(floor + "0" + room);
				} else {
					System.out.println(floor + "" + room);
				}
			} else {
				floor = N[i] % H[i];
				room = N[i] / H[i] + 1;
				if (room < 10) {
					System.out.println(floor + "0" + room);
				} else {
					System.out.println(floor + "" + room);
				}
			}
		}
	}
}
