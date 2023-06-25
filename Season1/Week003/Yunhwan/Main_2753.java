package Algorithm03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2753 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Short inputYear = Short.parseShort(br.readLine());
		//400의 배수일 때(윤년일 때)
		if(inputYear%400==0) {
			System.out.println(1);
		}else{
			//4의 배수이면서, 100의 배수가 아닐 때(윤년일때)
			if(inputYear%4==0&&inputYear%100!=0) {
				System.out.println(1);
			}else {//윤년이 아닐 때
				System.out.println(0);
			}
		}
	
	}
}
