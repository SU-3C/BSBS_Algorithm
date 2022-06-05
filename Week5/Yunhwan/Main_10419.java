package Algorithm05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10419 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 설정
		int testCase = Integer.parseInt(br.readLine());
		int[] lectureTime = new int[testCase];

//		지각시간을 담아줄 변수 선언
		int tardyTime = 0;

		for (int i = 0; i < testCase; i++) {
			// 반복 수행후 다시 비교를 위해 0으로 초기화
			tardyTime = 0;
			// 입력받음
			lectureTime[i] = Integer.parseInt(br.readLine());
			// 수업시간을 초과하지 않는 지각시간을 구하는 공식은
//			지각시간 + 지각시간^2 <= 수업시간
//			수업시간 >= 지각시간( 1+ 지각시간)
//			j는 지각시간, 지각시간을 수업시간까지 증가시켜보면서 최대 값을 tardyTime에 저장
			for (int j = 0; j < lectureTime[i]; j++) {
				if (lectureTime[i] - j * (1 + j) >= 0) {
					tardyTime = j;
				}//end if
			}//end second for

			System.out.println(tardyTime);
		}//end first for

	}
}
