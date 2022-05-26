package week4;

import java.util.Scanner;
//피보나치 수열
public class Main_2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte n = sc.nextByte();
        int f1 = 0, f2 = 1, s = f1 + f2;
        for (byte i = 1; i < n; i++){
            s = f1 + f2;
            f1 = f2;
            f2 = s;
        }
        System.out.print(s);
    }
}