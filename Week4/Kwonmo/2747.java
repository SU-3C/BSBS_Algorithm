package week4;

import java.util.Scanner;

public class Fibonachi2{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in); //화면에 입력을 받는다.		
		int n=sc.nextInt();
		int F1=0, F2=1, F3=1;
		for(int i=2; i<=n; i++) { //n이 2부터 시작이니까 반복문도 2부터 시작
			F3=F1+F2; //3번째수는 앞에 2개의 수의 합
			F1=F2; //반복한번을 할때마다 첫번재, 두번째 숫자가 하나씩 밀려남
			F2=F3;
		}
		System.out.println(F3);
		sc.close();
	}
}


/* 런타임 에러
package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonachi {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibo(n-1));
	}
	public static int fibo(int n) {
		if(n<=1)
			return 1;
		else
			return fibo(n-1) + fibo(n-2);
	}

}
//시간초과 발생






*/
