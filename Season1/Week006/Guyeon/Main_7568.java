package week6;

import java.io.*;
// 덩치 비교 문제
public class Main_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] wh = new int[N][2];
        // 배열에 값 채우기
        for (byte i = 0; i < N; i++){
            String[] hw = br.readLine().split(" ");
            for (byte j = 0; j < 2; j++){
                wh[i][j] = Integer.parseInt(hw[j]);
            }
        }
        int cnt = 0;
        // 요소 비교 포문
        for (byte i = 0; i < N; i++){
            for (byte j = 0; j < N; j++){
                if (i != j){
                    if (wh[i][0] < wh[j][0] && wh[i][1] < wh[j][1]) {
                        cnt++;
                    }
                }
            }
            bw.write((cnt+1)+" ");
            cnt = 0;
        }
        bw.flush();
    }
}