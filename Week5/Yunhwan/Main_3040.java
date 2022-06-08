package Algorithm05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte[] dwarfs = new byte[9];
//		9난쟁이 값을 모두 더해줄 sum 변수 [전부 더한 다음 가짜2명을 빼서 100이 나오면 해결]
		short sum = 0;
//		가짜난쟁이 2명 변수, 출력할때 해당 가짜 난쟁이를 난쟁이 배열에서 뛰어넘고 출력할려고 선언
		byte notDwarf01 = 0;
		byte notDwarf02 = 0;
		//난쟁이 값을 입력받고 동시에 더해줌
		for (int i = 0; i < dwarfs.length; i++) {
			dwarfs[i] = (byte) Integer.parseInt(br.readLine());
			sum += dwarfs[i];
		}
		//가짜난쟁이를  첫번째 인덱스부터 시작 8번째까지 반복 산정
		loop:
		for (int i = 0; i < dwarfs.length - 1; i++) {
			//첫번째 산정한 가짜난쟁이 나음 값을 두번째가짜난쟁이로 산정하여 반복
			//1-(2~9), 2-(3~9), ...
			for (int j = i + 1; j < dwarfs.length; j++) {
				//가짜 난쟁이 값을 제거후 100이면 전체 반복문을 빠져나옴
				if (sum - (dwarfs[i] + dwarfs[j]) == 100) {
					notDwarf01 = (byte) i;
					notDwarf02 = (byte) j;
					break loop;
				}
			}
		}
		for (int i = 0; i < dwarfs.length; i++) {
			if (i == notDwarf01 || i == notDwarf02) {
				continue;
			}
			System.out.println(dwarfs[i]);
		}
	}
}
