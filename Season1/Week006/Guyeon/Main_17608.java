package week6;

import java.io.*;
import java.util.Stack;
// 막대기 문제 스택
public class Main_17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n;i++){
            s.push(Integer.parseInt(br.readLine()));
        }
        int cnt=1;
        int top=s.pop();
        for (int i=n-2;i>=0;i--){
            if (s.get(i) > top){
                cnt++;
                top = s.get(i);
            }
        }
        bw.write(cnt+"");
        bw.flush();
    }
}