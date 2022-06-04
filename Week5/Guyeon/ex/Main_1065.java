package week5;

import java.io.*;

// 1 ~ N 사이의 한수 개수 구하기 
public class Main_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        if (N < 100) cnt = N;
        else {
            cnt = 99;
            for (int i = 100; i <= N; i++) {
                if ((i/100 - i/10%10) == (i/10%10 - i%10))
                    cnt++;
            }
        }
        bw.write(cnt+"");
        bw.flush();
    }
}

//                String s = Integer.toString(i);
//                if (Math.abs(s.charAt(0) - s.charAt(1)) == Math.abs(s.charAt(1) - s.charAt(2)))
//                    cnt++;