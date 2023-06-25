package week5;

import java.io.*;
import java.util.StringTokenizer;

// 루트 문제
public class Main_4619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String s="";
        int B;
        byte N;
        while(!(s=br.readLine()).equals("0 0")){
            st = new StringTokenizer(s);
            B = Integer.parseInt(st.nextToken());
            N = Byte.parseByte(st.nextToken());
            for (int i = 1; i <= B; i++){
                // B가 비교할 수는 2개
                // A^N <= B < (A+1)^N 이니까 아래 조건일 때만 비교 시작
                if ( B < Math.pow(i+1, N)){
                    if ( Math.pow(i, N) == B || (B - Math.pow(i, N) <= Math.pow(i + 1, N) - B)) {
                        bw.write(i + "\n");
                    } else {
                        bw.write((i+1) + "\n");
                    }
                    break;
                }
            }
        }
        bw.flush();
    }
}