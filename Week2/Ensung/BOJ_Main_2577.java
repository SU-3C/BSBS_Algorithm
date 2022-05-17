import java.util.Scanner;

public class BOJ_Main_2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		
		int[] counts = new int[10];
		int d = a*b*c;
		while(d>0) {
			
			 counts[d %10]++;
			 d /=10;
			 		
		
	}
		
		for (int i = 0; i < counts.length; ++i) {
			System.out.println(counts[i]);
		
	}

}
}
