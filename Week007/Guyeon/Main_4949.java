package week7;

import java.io.*;
import java.util.Stack;
//균형잡힌 세상 문제
public class Main_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Byte> s = new Stack<>();
        String in;
        while( !(in=br.readLine()).equals(".") ){
            for(byte c:in.getBytes()){
                if (c=='('||c=='[') s.push(c);
                else if (c==')' || c==']'){
                    if (s.empty()){
                        s.push((byte)'n');
                        break;
                    }
                    if ((c==')'&&s.peek()=='(') || (c==']'&&s.peek()=='[')){
                        s.pop();
                    } else if ( (c==')'&&s.peek()!='(') || (c==']'&&s.peek()!='[') ) {
                        break;
                    }
                }
            }
            bw.write( (s.empty()) ?"yes" + "\n":"no" + "\n");
            s.clear();
        }
        bw.flush();
    }
}