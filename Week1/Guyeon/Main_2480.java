import java.util.Scanner;
public class Main_2480 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt(), b = s.nextInt(), c = s.nextInt();
        int p;
        if (a == b && b == c){
            p = 10000+a*1000;
        } else if (a == b || a == c){
            p = 1000+a*100;
        } else if (b == c){
            p = 1000+b*100;;
        } else {
            p = (a > b)? a : b;
            p = (p > c)? p : c;
            p = p * 100;
        }
        System.out.print(p);
    }
}