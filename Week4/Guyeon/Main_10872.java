package week4;

import java.util.Scanner;
//팩토리얼
public class Main_10872 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte n = s.nextByte();
        int r = 1;
        for (byte i = 1; i < n; i++){
            r = r*(i+1);
        }
        System.out.print(r);
    }
}