import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Main_2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		// �Է°��� ���ڿ����� �����ְ�, ������ ���ڿ��� �ݴ�� �ٲ��ְ� �������ش��� �������� ������ ��ȯ
		int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

		
		if (a > b) {
			System.out.println(a);
			

		} else if (a < b) {
			System.out.println(b);

			}
		} 
}


