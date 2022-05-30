import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_10872 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		System.out.println(Mutiply(N));
		
		if(N<0) {
		System.out.println("1");	
		}

	}
	//재귀함수를 이용

	public static int Mutiply(int num) {
		if(num==0) {
			return 1;
			//0 일때 1로 결과값을 나타내고 종료
		}
		if (num == 1) {
			return 1;
			//1일떄 결과값을 나타내고 종료
			
		} else  {
			return num * Mutiply(num - 1);
			//1이 아니라면 1이 될때까지 반복문대로 결과값이 쌓여 출력  
		}

	}
}



/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_10872_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int fac =1;
		
		if(N==0) {
		System.out.println("1");	
		return;
		}	
		
		for (int i =N; i>=1; i--) {
			fac = fac * i;
			

				
		}
		System.out.println(fac);	
	}
	
}
*/


