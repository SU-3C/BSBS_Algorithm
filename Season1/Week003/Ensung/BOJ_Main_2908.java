import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Main_2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 입력값의 문자열들을 더해주고, 더해진 문자열을 반대로 바꿔주고 리턴해준다음 마지막에 정수로 변환
		int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

		
		if (a > b) {
			System.out.println(a);
			

		} else if (a < b) {
			System.out.println(b);

			}
		} 
}


