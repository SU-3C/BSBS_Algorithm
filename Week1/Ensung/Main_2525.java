import java.util.Scanner;

public class Main_2525 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		//입력값
		int d = a*60 + b + c;
		a = d/60;
		b = d%60;
		//치환하는 값
		
		
		if (a >=24) {
			a = a-24;
			//a 가 24가 넘어가면 00으로 바뀌는 함수
		}
		System.out.println(a + " " + b);

		
		
	}

}
