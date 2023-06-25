import java.util.Scanner;

public class Main_10871 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(), X = s.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++){
            A[i] = s.nextInt();
            if (A[i] < X) System.out.print(A[i] + ( (i == A.length-1)?"" : " "));
        }
    }
}