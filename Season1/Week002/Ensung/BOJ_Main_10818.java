import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Main_10818 {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int num[]  = new int[a];
		
		for(int i = 0; i<num.length; i++) {
			num[i] = sc.nextInt();

		}
		Arrays.sort(num);
		//������ ������������ �迭�Ѵ�.
		
		System.out.println(num[0] + " " + num[a -1]);
		// 0�� �������� �ּҰ� , -1�� �ִ밪
		
	}
}