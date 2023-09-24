package programmers;

import java.io.*;
import java.util.*;
class backjun{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer in = null;
    static int n = 0, m = 0;
    static int[] stair = null, dp = null;
    public static void main(String[] args) throws IOException {
        init();
        for(int i = 4; i <= n; i++){
            dp[i] = stair[i] + Math.max(dp[i-2], stair[i-1] + dp[i-3]);
        }
        finish(dp[n]);
    }

    static int func(int i){
        if (i <= 3 || dp[i] > 0){
            return dp[i];
        }
        dp[i] = stair[i] + Math.max(func(i-2), stair[i-1] + func(i-3));
        return dp[i];
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        stair = new int[n+1];
        dp = new int[n+1];
        stair[0] = 0;
        for(int i = 1; i <= n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        if (n >= 1) dp[1] = stair[1];
        if (n >= 2) dp[2] = stair[1] + stair[2];
        if (n >= 3) dp[3] = (stair[1]+stair[3] > stair[2]+stair[3]) ? stair[1]+stair[3] : stair[2]+stair[3];
    }
    static void finish(int v) throws IOException {
        bw.write(v + "\n");
        bw.flush();
        bw.close();
    }
}
