import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_2753 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(bf.readLine());
		// a�� 4�� ����̰ų� 100����� �ƴҶ�
		if ((a % 4) == 0 && (a%100) != 0) {
			System.out.println("1");
			
			//4�ǹ���ų� 400�ǹ���϶�
		} else if ((a % 4) == 0 && (a % 400) == 0) {
			System.out.println("1");
			//������
		} else {
			System.out.println("0");
		}

	}

}