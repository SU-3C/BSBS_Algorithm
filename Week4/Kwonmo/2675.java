package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		
		for(int i=0;i<T;i++){ 
			String[] str = br.readLine().split(" "); //input에서의 공백을 분리하여 공백기준으로 나뉜것을 배열에 각각 담음
			//sc쓸꺼면 공백을 기준으로 하나만 읽어오는 next()사용하면 될 것이다.
			int R = Integer.parseInt(str[0]);
			String S = str[1]; //찐 문자열
			for(int j=0;j<S.length();j++) {
				for(int k=0;k<R;k++) {
					System.out.print(S.charAt(j)); //문자열에서 k번째 문자열을 char화시켜서 추출
				}
			}
			System.out.println();
		}
	}
}
