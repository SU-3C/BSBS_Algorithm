package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 곱하기 결과의 숫자 개수 문제
public class Main_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short a = Short.parseShort(br.readLine()), b = Short.parseShort(br.readLine()), c = Short.parseShort(br.readLine());
        int result = a*b*c;
        //String[] buffer = Integer.toString(a*b*c).split("");
        byte[] res = new byte[10];
//        for(byte i = 0; i < buffer.length; i++){
//            ++res[Byte.parseByte(buffer[i])];
//        }
        for (int i = result; i > 0; i /=10){
            ++res[i%10];
        }

        for(byte i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        bw.write(res[i]+"\n");
//                bw.flush();
//                bw.close();