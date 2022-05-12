package Algorithm;

import java.util.Scanner;

public class Main_14681 {
	public static void main(String[] args) {
		// 콘솔에서 값을 입력 받기 위한 Scanner객체 생성
		Scanner scan = new Scanner(System.in);
		
		int x,y;;
		x = scan.nextInt();
		y = scan.nextInt();
		
		if(x>0&&y>0) {
			System.out.println(1);
		}else if(x<0&&y>0) {
			System.out.println(2);
		}else if(x<0&&y<0) {
			System.out.println(3);
		}else if(x>0&&y<0) {
			System.out.println(4);
		}
	}
}
