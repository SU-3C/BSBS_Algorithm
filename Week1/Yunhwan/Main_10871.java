package Algorithm;

import java.util.Scanner;
public class Main_10871{
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int X = scanner.nextInt();
		int[] numberArray = new int[N];
		int[] smallNumberArray = new int [N];
		//작은 수 인덱스 조종을 위한 변수
		int k=0;
		//N값 만큼 값입력 받기
		for(int i=0; i<N;i++) {
			numberArray[i]= scanner.nextInt();
			//입력받은 값이 X보다 작으면 작은 숫자 배열에 저장
			if(numberArray[i]<X) {
				smallNumberArray[k]=numberArray[i];
				k++;
			}
		}
		//
		for(int i=0; i<k; i++) {
			System.out.print(smallNumberArray[i]);
			//마지막값이 아니면 공백 출력
			if(i+1!=k) {
				System.out.print(" ");
			}
		}
	}
}