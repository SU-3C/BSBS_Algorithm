package Algorithm02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958 {
	public static void main(String[] args)throws IOException{//버퍼리더를 쓰기위한 예외던지기 {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int inputNum = Integer.parseInt(br.readLine());
			String[] inputTestCase = new String[inputNum];
			// 결과값을 넣어줄 배열
			short[] resultSum = new short[inputNum];
			// 연속된 문자 처리를 위한 변수
			byte count = 0;

			// 테스트케이스 입력받기
			for (int i = 0; i < inputTestCase.length; i++) {
				inputTestCase[i] = br.readLine();

				// 입력받은 값을 점수로 계산하는 for문 j
				for (int j = 0; j < inputTestCase[i].length(); j++) {
					// O 이면
					if (inputTestCase[i].charAt(j) == 'O') {
						count++;
						resultSum[i] += count;
					}
					// 'O'이 아니면 가변가수 0으로 초기화
					else {
						count = 0;
					}
				} // end for j
				// 합계구하는 for문 종료시 남아있는 count초기화
				count = 0;
			} // end for i
			// 값을 출력하는 for문
			for (int i = 0; i < resultSum.length; i++) {
				System.out.println(resultSum[i]);
			}
			// 버퍼종료
			br.close();
		} catch (IOException e) {
		}
	}
}
