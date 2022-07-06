package week7;

import java.io.*;
import java.util.Stack;

public class Main_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> s = new Stack<>();
        String in=br.readLine();
        for (int i=0;i<in.length();i++){
            char c=in.charAt(i);
            if (c=='<' || c==' '){
                while(!s.empty()) bw.write(s.pop());
                if(c==' ') bw.write(" ");
                if (c=='<'){
                    int j=i;
                    while (in.charAt(++j)!='>');
                    bw.write(in.substring(i,j+1));
                    i=j;
                }
            } else {
                s.push(c);
                if(i==in.length()-1)
                    while(!s.empty()) bw.write(s.pop());
            }
        }
        bw.flush();
    }
}