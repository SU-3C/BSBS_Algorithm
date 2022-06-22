import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_Main_4619 {

	public static void main(String[] args) throws IOException {

		 Scanner sc = new Scanner(System.in);
		while (true) {

			//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			//StringTokenizer st = new StringTokenizer(bf.readLine());
			//int B = Integer.parseInt(st.nextToken());
			//int N = Integer.parseInt(st.nextToken());
			 int B = sc.nextInt();
			 int N = sc.nextInt();
			int nowValue;
			int lastValue = 1000001; 
			//현재 값이랑 마지막값 마지막은 나올수있는 최대수
			if (B == 0 && N == 0)
				break;
			//00일때 테스트 케이스 종료
			else {
				for (int i =1;;i++) {
					nowValue = (int) Math.abs(B-Math.pow(i,N)); 
					// 현재 값은 i^N 에서 B를 빼면 
					// 음수값이 나와서 절대값으로 음수값을 없앴다.
						if(nowValue>lastValue) {
							System.out.println(i-1);
							break;
							//첫번째값부터 점점 감소되다가 n번째가 증가하는 시점이있다.
							//증가하는 인덱스에서 i-1을하면 최적의값이다.
							//그리고 종료한다.
						}
						else {
							lastValue=nowValue;
							//만약 아니면 마지막값이랑 지금값을 동일하게 두고 다시 반복한다.
						}
							
					}
				}
		}
		}
	}

