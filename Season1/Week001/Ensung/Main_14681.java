import java.util.Scanner;

public class Main_14681 {
		public static void main(String[] args) {
			
	int x= 0;
	int y= 0;
	
	Scanner sc = new Scanner(System.in);
	
	x = sc.nextInt();

	y = sc.nextInt();
	
	if(x > 0 && y > 0) {
		System.out.println("1");
	}
	if ( x < 0 && y > 0 ) {
		System.out.println("2");
		
	}
	if ( x < 0 && y < 0 ) {
		System.out.println("3");
		
	}
	if ( x > 0 && y < 0 ) {
		System.out.println("4");
		
	}
	
}
}

