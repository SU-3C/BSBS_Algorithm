import java.util.Scanner;
 
class Main_10991 {
	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        
        for (int i = 1; i <= n; i++)
        {
            for (int j = i; j <= n - 1; j++)
            {
                System.out.print(" ");
            }
            for (int j = 1; j <= i*2-1; j++)
            {
                if (j % 2 == 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
