import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Main_4153 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 피타고라스의 정리 중에 a^2 + b^2 = c^2 입니다 근데 여기선 
			// 정확한 위치를 안정해줬으므로 a의 직각의값, b의 직각의값, c직각의값의 경우의수를 다 구해야합니다.
			if (a * a + b * b == c * c) {
				System.out.println("right");
			} else if (a * a == b * b + c * c) {
				System.out.println("right");
			} else if (a * a + c * c == b * b) {
				System.out.println("right");

			} else {
				System.out.println("wrong");
			}
			if (a == 0 && b == 0 && c == 0) { //  0 0 0 이되면 반복을 중지한다.
				break;
			}
		}
	}
}
