package programmers;

import java.io.*;
import java.util.*;

class backjun {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer in = null;
    static int n = 0;
    static int[] dp = null;
    public static void main(String[] args) throws IOException {
        init();
        finish();
    }

    static void init() throws IOException{
        in = new StringTokenizer(br.readLine());
        n = Integer.parseInt(in.nextToken());
        dp = new int[n+1];
        func(n);
        keepBuffer(dp[n]);
    }

    static int func(int n) {
        if(n < 2) return dp[n] = n;
        if (dp[n] > 0) return dp[n];
        int idx = 1;
        while(n - (int)Math.pow(idx, 2) >= 0) {
            int temp = 1 + func(n - (int)Math.pow(idx, 2));
            if(dp[n] == 0 || temp < dp[n]){
                dp[n] = temp;
            }
            idx++;
        }
        return dp[n];
    }

    static void keepBuffer(int v) throws IOException {
        bw.write(v + "\n");
    }
    static void finish() throws IOException {
        bw.flush();
        bw.close();
    }
}

//    static void finish() throws IOException {
//        bw.write(result + "\n");
//        bw.flush();
//        bw.close();
//    }

//    static void finish(int sum) throws IOException {
//        bw.write(sum + "\n");
//        bw.flush();
//        bw.close();
//    }
