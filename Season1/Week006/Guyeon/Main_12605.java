package week6;

import java.io.*;
import java.util.Stack;
// 단어 뒤집기
public class Main_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        byte n = Byte.parseByte(br.readLine());
        for (int i=0;i<n;i++){
            String[] in = br.readLine().split(" ");
            bw.write("Case #"+(i+1)+": ");
            for (int j = in.length-1; j>=0; j--){
                bw.write(in[j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}