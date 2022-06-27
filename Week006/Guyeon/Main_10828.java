package week6;

import java.io.*;
import java.util.Stack;
// 스택 문제
public class Main_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            String[] in = br.readLine().split(" ");
            switch (in[0]){
                case "push":
                    s.push(Integer.parseInt(in[1]));
                    break;
                case "pop":
                    bw.write((s.empty())? "-1"+"\n" : s.pop() + "\n");
                    break;
                case "size":
                    bw.write(s.size()+"\n");
                    break;
                case "empty":
                    bw.write((s.empty())? "1"+"\n" : "0"+"\n");
                    //bw.write(Integer.parseInt(s.empty()));
                    break;
                case "top":
                    bw.write((s.empty())? "-1"+"\n" : s.peek() + "\n");
                    break;
            }
        }
        bw.flush();
    }
}