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
			
			// ��Ÿ����� ���� �߿� a^2 + b^2 = c^2 �Դϴ� �ٵ� ���⼱ 
			// ��Ȯ�� ��ġ�� �����������Ƿ� a�� �����ǰ�, b�� �����ǰ�, c�����ǰ��� ����Ǽ��� �� ���ؾ��մϴ�.
			if (a * a + b * b == c * c) {
				System.out.println("right");
			} else if (a * a == b * b + c * c) {
				System.out.println("right");
			} else if (a * a + c * c == b * b) {
				System.out.println("right");

			} else {
				System.out.println("wrong");
			}
			if (a == 0 && b == 0 && c == 0) { // �����߿� 0 0 0 �̵Ǹ� �ݺ��� �����Ѵ�.
				break;
			}
		}
	}
}
