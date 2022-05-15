package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ACM 호텔 문제
public class Main_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short T = Short.parseShort(br.readLine());
        int[] data = new int[3];
        StringBuilder sb = new StringBuilder();
        for (byte i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (byte j = 0; j < 3; j++)
                data[j] = Integer.parseInt(st.nextToken());
            int X = (data[2]-1) / (data[0]) + 1;
            int Y = data[2] - (data[0]*(X-1));
            sb.append((Y*100+X) + "\n");
        }
        System.out.print(sb);
    }
}
// 6 12 N
//    Y X
//1 = 101
//2 = 201
//3 = 301
//4 = 401
//5 = 501
//6 = 601
//7 = 102
//8 = 202
//9 = 302
//10 = 402
//11 = 502
//12 = 602
//13 = 103
//14 = 203
//System.out.println("Y : " + Y + " X : " + X);

//    Scanner s = new Scanner(System.in);
//    short T = s.nextShort();
//            for (byte j = 0; j < 3; j++)
//        data[j] = s.nextInt();
//    short H = Short.parseShort(br.readLine());
//    short W = Short.parseShort(br.readLine());
//    short N = Short.parseShort(br.readLine());