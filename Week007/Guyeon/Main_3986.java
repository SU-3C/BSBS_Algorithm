package week7;

import java.io.*;
import java.util.Stack;
// AB가 서로 잘연결되는지 좋은 단어 찾기 문제
public class Main_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> s = new Stack<>();
        int n=Integer.parseInt(br.readLine());
        int cnt=0;
        for (int i=0;i<n;i++){
            String in=br.readLine();
            if(in.length()%2==0){
                for(int j=0;j<in.length();j++){
                    char c=in.charAt(j);
                    if(s.empty() || s.peek()!=c){
                        s.push(c);
                    } else {
                        s.pop();
                    }
                }
                if (s.empty()) cnt++;
                s.clear();
            }
        }
        bw.write(cnt+"");
        bw.flush();
    }
}