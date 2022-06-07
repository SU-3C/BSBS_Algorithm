package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Late {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.in에서 입력스트림을 받아오는 BufferedReader 객체 생성
		int T=Integer.parseInt(br.readLine());
		//br은 String형을 readLine하기 때문에 int형으로 형변환
		
		
		for(int i=0;i<T;i++) {
			int d=Integer.parseInt(br.readLine());
			int t = 1;
			while(t*t+t<=d) {//지각한 시간의 제곱 + 지각한시간 = 전체수업시간
				t++; //결국 t가 조건을 만족할때까지 증가
			}
			System.out.println(t-1);
			//while문을 빠져 나온 t는 우리가 원하는 조건보다 1증가된 상태
			
		}
	}

}
