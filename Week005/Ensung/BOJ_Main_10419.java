import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_10419 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) { //테스트 케이스 할 값
			int d = Integer.parseInt(bf.readLine());
			int late = 0; //변수 선언
			for (late = 0;; late++) { 
				if (d < late + late*late) { 
					late = late - 1;
					break;
				}
				// 수업시간이 d고 late가 교수이 늦게 오는 시간 late x late는 일찍끝내주는시간
				// 늦게온시간+일찍끝내준시간이 총시간보다 커질때 그시점에서 -1을 해주면 최적의 시간이다.
			}
			System.out.println(late);
		}

	}

}
