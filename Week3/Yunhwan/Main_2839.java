package Algorithm03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {
	public static void main(String[] args) throws IOException {
		// 증감 패턴
		// 3부터시작 3 - 9 - 5 - 6 - 12
		// 예외 숫자 4, 7
		byte[] patternNum = new byte[5];
		patternNum[0] = 3;
		patternNum[1] = 9;
		patternNum[2] = 5;
		patternNum[3] = 6;
		patternNum[4] = 12;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		short countBag = 0;
		short restSuger = 0;
		short input = Short.parseShort(br.readLine());
		//패턴 예외값일 경우
		if (input == 4 || input == 7) {
			System.out.println(-1);
		//5k로 봉지로 다 담기면
		} else if (input % 5 == 0) {
			System.out.println(input / 5);
		//나눠 담으면
		} else {
			for (int i = 0; i < patternNum.length; i++) {
				//패턴 수값을 빼줘서 5로 나누어 떨어지면 처리하는 코드
				restSuger = (short) (input - patternNum[i]);
				if (restSuger % 5 == 0) {
					//총 봉지의 갯수					5k봉지에 담는 갯수  나머지 3k봉지에 담는 갯수
					countBag = (short) ((short) (restSuger/5) +patternNum[i]/3);
					System.out.println(countBag);
				}
			}
		}
	}
}

//		// 5로 나누어 떨어지면 5킬로 봉지로 다담아
//		if (input % 5 == 0) {
//			System.out.println(input / 5);
//		} else if (input > 27) {
//			switch (input % 10) {
//			case 1:
//				restSuger = (short) (input - 21);
//				countBag= (short) (restSuger/5 +7);
//				System.out.println(countBag);
//				break;
//			case 2:
//				restSuger = (short) (input - 12);
//				countBag= (short) (restSuger/5 +4);
//				System.out.println(countBag);
//				break;
//			case 3:
//				restSuger = (short) (input - 12);
//				countBag= (short) (restSuger/5 +1);
//				System.out.println(countBag);
//				break;
//			case 4:
//				restSuger = (short) (input - 12);
//				countBag= (short) (restSuger/5 +8);
//				System.out.println(countBag);
//				break;
//			case 6:
//				restSuger = (short) (input - 12);
//				countBag= (short) (restSuger/5 +2);
//				System.out.println(countBag);
//				break;
//			case 7:
//				restSuger = (short) (input - 12);
//				countBag= (short) (restSuger/5 +9);
//				break;
//			case 8:
//				restSuger = (short) (input - 12);
//				countBag= (short) (restSuger/5 +6);
//				System.out.println(countBag);
//				break;
//			case 9:
//				restSuger = (short) (input - 12);
//				countBag= (short) (restSuger/5 +3);
//				System.out.println(countBag);
//				break;
//			}
//		}else if(input%3==0){
//			System.out.println(input/3);
//		}else {
//			System.out.println(-1);
//		}