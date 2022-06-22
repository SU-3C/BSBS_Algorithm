import java.util.Scanner;

public class Main_10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		int X;
		N = sc.nextInt();
		X = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			
			int A = sc.nextInt();
			
			if (A < X)
				
				System.out.print(A + " ");
		}
	}
}
