package week5;

import java.io.*;
//  교수님 지각 문제
public class Main_10419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        byte T = Byte.parseByte(br.readLine());
        for (byte i = 0; i < T; i++){
            short d = Short.parseShort(br.readLine());
            short t = 0;
            // d에 1이 들어올수있어서 t는 0으로 시작하기 무조건 한번은 반복되게
            // d가 1이면 한번 반복 후 t가 ++됨
            // d가 1이상이면 t+t*t 가 d 보다 큰 경우 그것의 바로 아래 수를 출력해야함
            // 때문에 t-1를 write 해줌
            for (t = 0; t < d; t++){
                if (t + t*t > d){
                    break;
                }
            }
            bw.write((t-1) + "\n");
        }
        bw.flush();
    }
}