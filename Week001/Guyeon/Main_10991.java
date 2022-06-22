import java.util.Scanner;
public class Main_10991 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++){
            for (int j = n-i; j > 1; j--){
                System.out.print(" ");
            }
            for (int k = 0; k < i*2 + 1; k++){
                if (k % 2 == 0) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
