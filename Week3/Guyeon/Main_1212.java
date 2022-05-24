package week3;

import java.io.*;

// 1212번 8진수 2진수
public class Main_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String o = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 첫 문자의 2진수는 0이 없어야하므로 숫자형으로 바꿔서 2진수로 만들기
        byte b = (byte) (o.charAt(0) - 48);
        bw.write(Integer.toBinaryString(b));
        for (int i = 1; i < o.length(); i++){
            // char형을 2진수로 변환하기 때문에 48을 더한 값이 자동으로 들어감
            // ex ) char 1을 2진수로 변환 시 49로 110001이 됨
            // -48을 2진수 상으로 시도해보면 뒤의 3자리만 남음
            // 이것도 0번째 문자처럼 48을 빼고 2진수로 바꾸면 1자리 2자리수로 반환됨 그래서 3자리 맞춰주기 위해 이렇게 함
            String t = Integer.toBinaryString(Integer.valueOf(o.charAt(i))).substring(3, 6);
            bw.write(t);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}