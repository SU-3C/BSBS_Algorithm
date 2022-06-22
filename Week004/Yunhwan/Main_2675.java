package Algorithm04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());

		int[] loopNum = new int[testNum];
		String[] testcase = new String[testNum];
		String temp = "";
		
		//테스트케이스입력받는 반복문
		for (int i = 0; i < testNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			loopNum[i] = Integer.parseInt(st.nextToken());
			testcase[i] = st.nextToken();
		}
		//전체 테스트 갯수만큼 반복
		for (int i = 0; i < testcase.length; i++) {
			//해당 요소의 문자열 길이만큼 반복
			for(int j=0; j<testcase[i].length();j++) {
				//해당 문자값을 정해준 반복횟수만큼 반복
				for(int k=0;k<loopNum[i];k++) {
					temp+=testcase[i].charAt(j);
				}
			}
			//반복해준 문자열값을 넣어줌
			testcase[i] = temp;
			temp="";
		}
		//출력
		for(int i =0; i<testcase.length;i++) {
			System.out.println(testcase[i]);
		}
	}
}
