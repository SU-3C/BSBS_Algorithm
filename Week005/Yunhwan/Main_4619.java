package Algorithm05;

import java.util.Scanner;

public class Main_4619 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int B;
		int N;
		int A = 0;//
		//반복문으로 입력받고 바로 계산해서 출력후 다시 입력받음
		while (true) {
			B = scanner.nextInt();
			N = scanner.nextInt();
			//마지막이 0으로 입력 받으면 반복문 빠져나옴
			if (B == 0)
				break;
			//입력한 값의 결과 값 차이 계산을 위한 변수1 초기화
			double temp = 1000000d;
			//크기 비교에 싸용될 변수2
			double gap;
			//입력조건 최대값이 1,000,000으로 1000000까지 반복
			for (int i = 0; i <= 1000000; i++) {
				// A^n = B으로 값이 같다고 가정
				// 0 = B - A^n 으로 계산한 값의 절대값으로 값을 넣어줌
				gap = Math.abs(B - Math.pow(i, N));
				//이전 값보다 값이 작으면 B와 가까운 것이므로
				//현재 값을 제일 작은 값으로 판단, temp값에는 현재 차이값을, A값에 현재 인덱스값을 넣어줌
				if (gap < temp) {
					temp = gap;
					A = i;
				}
			}//end for
			System.out.println(A);
		}//end loop
	}
}
