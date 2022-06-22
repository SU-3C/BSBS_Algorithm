package week4;

import java.io.*;
import java.util.StringTokenizer;
//문자열반복
public class Main_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short n = Short.parseShort(br.readLine());
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (short i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            byte rp = Byte.parseByte(st.nextToken());
            String S = st.nextToken();
            for (byte j = 0; j < S.length(); j++){
                for (byte k = 0; k < rp; k++)
                    bw.write(S.charAt(j));
            }
            bw.write("\n");
        }
        bw.flush();
    }
}