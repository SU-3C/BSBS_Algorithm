package week5;

import java.io.*;
import java.util.StringTokenizer;

// 1476 날짜 계산
public class Main_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        byte E = Byte.parseByte(st.nextToken());
        byte S = Byte.parseByte(st.nextToken());
        byte M = Byte.parseByte(st.nextToken());
        int year = 1;
        byte e = 1, s = 1, m = 1;
        while(!(e == E && s == S && m == M)){
            e = (byte) ((e+1 > 15)?1:e+1);
            s = (byte) ((s+1 > 28)?1:s+1);
            m = (byte) ((m+1 > 19)?1:m+1);
            year++;
            System.out.println(e + ", " + s + ", " + m);
        }
        bw.write(year+"");
        bw.flush();
    }
}