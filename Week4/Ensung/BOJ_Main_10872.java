import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_10872 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		System.out.println(Mutiply(N));
		
		if(N<0) {
		System.out.println("1");	
		}

	}
	//����Լ��� �̿�

	public static int Mutiply(int num) {
		if(num==0) {
			return 1;
			//0 �϶� 1�� ������� ��Ÿ���� ����
		}
		if (num == 1) {
			return 1;
			//1�ϋ� ������� ��Ÿ���� ����
			
		} else  {
			return num * Mutiply(num - 1);
			//1�� �ƴ϶�� 1�� �ɶ����� �ݺ������ ������� �׿� ���  
		}

	}
}



/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_10872_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int fac =1;
		
		if(N==0) {
		System.out.println("1");	
		return;
		}	
		
		for (int i =N; i>=1; i--) {
			fac = fac * i;
			

				
		}
		System.out.println(fac);	
	}
	
}
*/


