package week5;

import java.io.*;
// 체스판 문제
public class Main_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte cnt = 0; // 말 개수 셀 변수

        for (byte i = 0; i < 8; i++){
            String s = br.readLine();
            // 위에서 입력 받고
            // i가 짝수면 j는 0부터 i가 홀수면 j는 1부터 시작하고 2씩 더해주기
            // i = 0 : j = 0, 2, 4, 6
            // i = 1 : j = 1, 3, 5, 7
            // F면 cnt++
            for (byte j = (byte) ((i%2==0)?0:1); j < 8; j+=2){
                if (s.charAt(j) == 'F') cnt++;
            }
        }
        System.out.println(cnt);
    }
}