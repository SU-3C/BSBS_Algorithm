package week6;

import java.io.*;
import java.util.Stack;
// 괄호 스택문제
public class Main_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++){
            String in = br.readLine();
            int j;
            for (j=0;j<in.length();j++){
                char c=in.charAt(j);
                if (c=='(') s.push(c);
                else {
                    if (s.empty()){
                        break;
                    } else {
                        s.pop();
                    }
                }
            }
            if (j==in.length() && s.empty()) bw.write("YES\n");
            else bw.write("NO\n");
            s.clear();
        }
        bw.flush();
    }
}