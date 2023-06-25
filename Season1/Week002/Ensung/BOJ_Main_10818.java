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
		//정렬의 오름차순으로 배열한다.
		
		System.out.println(num[0] + " " + num[a -1]);
		// 0이 가장작은 최소값 , -1이 최대값
		
	}
}