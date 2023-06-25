package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2908번 상수문제
public class Main_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] a = input.split(" ");
        short A = Short.parseShort(a[0]);
        short B = Short.parseShort(a[1]);
        A = s(A);
        B = s(B);
        System.out.print((A>B)?A:B);
    }

    // 1의 자리와 100의 자리수 바꾸는 함수
    public static short s(short value){
        short X = (short) (value % 10);
        short Y = (short) (value/10%10);
        short Z = (short) (value / 100);
        return (short) (Z + Y*10 + X * 100);
    }
}
