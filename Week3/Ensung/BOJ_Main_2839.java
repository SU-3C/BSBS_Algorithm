import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		//a:5키로 봉지 개수 b:3키로 봉지 개수
		int a, b;
	
		// a는 5kg 봉지 개수 , N은 나머지 값 
		a = N / 5;
		N = N % 5;
		
		while (true) {
			if(N%3==0) {
				b=N/3;
				break;
				// 나머지값이 3의배수로 나눠지면 몫(3kg봉지개수)를 얻는다. 그리고 반복문을 종료한다.
			}
			else {
				a--;
				N+=5;
				// 나머지값이 안되면 몫에서 하나를 빼고 나머지에 5를 더해 다시 반복을한다.
			}
			
			if(a<0) {
				System.out.println("-1");
				return;
				//더 이상 몫이 없어서 나눠줄수 없을때 -1로 설정한다.그리고 결과를 종료한다.
			}
		}
		System.out.println(a+b);
	}
}