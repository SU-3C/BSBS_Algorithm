import java.util.Scanner;

public class Main_2525 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		//�Է°�
		int d = a*60 + b + c;
		a = d/60;
		b = d%60;
		//ġȯ�ϴ� ��
		
		
		if (a >=24) {
			a = a-24;
			//a �� 24�� �Ѿ�� 00���� �ٲ�� �Լ�
		}
		System.out.println(a + " " + b);

		
		
	}

}
