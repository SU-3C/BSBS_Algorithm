package week6;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
// 제로 입력 시 pop
public class Main_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine()), sum=0;
        for (int i=0;i<n;i++){
            int in = Integer.parseInt(br.readLine());
            if (in>0){
                s.push(in);
            } else {
                s.pop();
            }
        }
        for (int i : s){
            sum+=i;
        }
        bw.write(sum+"");
        bw.flush();
    }
}