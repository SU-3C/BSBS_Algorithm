import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		//a:5Ű�� ���� ���� b:3Ű�� ���� ����
		int a, b;
	
		// a�� 5kg ���� ���� , N�� ������ �� 
		a = N / 5;
		N = N % 5;
		
		while (true) {
			if(N%3==0) {
				b=N/3;
				break;
				// ���������� 3�ǹ���� �������� ��(3kg��������)�� ��´�. �׸��� �ݺ����� �����Ѵ�.
			}
			else {
				a--;
				N+=5;
				// ���������� �ȵǸ� �򿡼� �ϳ��� ���� �������� 5�� ���� �ٽ� �ݺ����Ѵ�.
			}
			
			if(a<0) {
				System.out.println("-1");
				return;
				//�� �̻� ���� ��� �����ټ� ������ -1�� �����Ѵ�.�׸��� ����� �����Ѵ�.
			}
		}
		System.out.println(a+b);
	}
}