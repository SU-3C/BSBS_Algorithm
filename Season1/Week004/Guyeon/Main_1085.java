package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//직사각형 탈출
public class Main_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        short x = Short.parseShort(st.nextToken());
        short y = Short.parseShort(st.nextToken());
        short w = Short.parseShort(st.nextToken());
        short h = Short.parseShort(st.nextToken());
        y = (short) ((h-y < y)?h-y:y);
        x = (short) ((w-x < x)?w-x:x);
        System.out.print((x<y)?x:y);
    }
}
