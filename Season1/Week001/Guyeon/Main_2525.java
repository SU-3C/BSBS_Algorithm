import java.util.Scanner;
public class Main_2525 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int h = s.nextInt();
        int m = s.nextInt();
        int t = s.nextInt();
        m += t;
        int p = m/60;
        if (p > 0) {
            m -= (p * 60);
            h = (h+p>23)?h = h+p-24 : h + p;
        }
        System.out.print(h + " " + m);
    }
}