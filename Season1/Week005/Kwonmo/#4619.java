package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak4619 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int smallerNum = 0, biggerNum=0;
			
			//0 0 입력되면 무한루프 종료
			if(B == 0 && N == 0) {
				break;
			}
			int A = 0;
			while(true) {
				//A의 N제곱이 B보다 작거나 같거나 클때에 맞춰 smallerNum, biggerNum에 저장. 클경우엔 저장하고 반복문 종료
				double compare=Math.pow(A,N);
				if(compare <= B) {
					smallerNum = A;
				}else if(compare > B){
					biggerNum = A;
					break;
				}
				//반복문이 계속되는 동안 A에 1씩 더해야한다.
				A++;
			}

			//두 값의 차이를 가지고 값을 판단해야 하므로 음수가 나오면 안되니 절댓값으로 구해야함
			int result=0;
			if(Math.abs(Math.pow(smallerNum, N) - B) <= Math.abs(Math.pow(biggerNum, N) - B)) {
				result=smallerNum;
			}
			else result=biggerNum;
			
			System.out.println(result);
		}
	}

}
