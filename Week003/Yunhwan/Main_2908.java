package Algorithm03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//값을 입력받기 위한 변수, 값의 자리를 바꿔주기 위한 변수 선언
		short[] input = new short[2];
		char[][] value = new char[2][3];
		//버퍼로 읽은 값을 토크나이저로 나눠 변수에 담는 코드
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2; i++) {
			input[i] = Short.parseShort(st.nextToken());
		}
		//입력 받은 값을 나눈 나머지는 해당 자릿수 -> 
		// 끝자리 수부터 도출됨 -> 나온값을 순서대로 넣으면 역순 위치
		for (int i = 0; i < value.length; i++) {
			//입력받은 값을 나눠준 몫을 담기 위해, 다음 자리수를 구하기 위해 임시 변수 선언
			short temp = input[i];
			//입력받은 값의 자리 순서를 바꿔주는 for문
			for (int j = 0; j < value[i].length; j++) {
				//세자리 수 조건이므로 문자형 배열에 해당 자리수의 값을 넣어줌
				// 나눠준 값은 문자형 값이 아니므로 형 변환
				value[i][j] = (char) (temp % 10 + '0');
				//다음 자리수를 구하기 위해 나눠준 몫을 임시 변수에 초기화
				temp /= 10;
			}
			//반복이 끝나고 바꿘 문자형 배열값을 앞서 사용한 input변수에 넣어서 재활용
			input[i] = Short.parseShort(String.valueOf(value[i]));
		}
		if(input[0]>input[1]) {
			System.out.println(input[0]);
		}else {
			System.out.println(input[1]);
		}
		
	}
}
