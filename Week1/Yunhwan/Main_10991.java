package Algorithm;

import java.util.Scanner;

public class Main_10991{
    	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int star = scanner.nextInt();

		// 행단위 for문
		for (int i = 0; i < star; i++) {
			//별 앞에 공백 출력
			for (int j=i+1;j<star;j++) {
				System.out.print(" ");
			}//end for 앞 공백
			
			//별출력
			for(int k =1; k<=2*i+1; k++) {
				if(k%2==0) {
					System.out.print(" ");
				}
				else{System.out.print("*");}
			}//end for 별출력
			System.out.print("\n");
		}//end for 행단위
	}
}