package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 직각삼각형
public class Main_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        short[] a = new short[3];
        StringBuilder sb = new StringBuilder();
        while ( !(s = br.readLine()).equals("0 0 0")){
             st = new StringTokenizer(s);
            for (byte i = 0; i < 3; i++)
                a[i] = Short.parseShort(st.nextToken());
            Arrays.sort(a);
            if (a[0]*a[0] + a[1]*a[1] == a[2]*a[2]) sb.append("right"+"\n");
            else sb.append("wrong"+"\n");
        }
        System.out.print(sb);
    }
}