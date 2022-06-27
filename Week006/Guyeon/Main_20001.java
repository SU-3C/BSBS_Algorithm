package week6;

import java.io.*;
    import java.util.Stack;
// 고무오리 디버깅
public class Main_20001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> s = new Stack<>();
        String start = br.readLine();
        if (start.equals("고무오리 디버깅 시작")) {
            while (true) {
                start = br.readLine();
                if (start.equals("고무오리")) {
                    if (s.empty()) {
                        s.push(s.push("문제"));
                    } else {
                        s.pop();
                    }
                } else if (start.equals("문제")) {
                    s.push(start);
                } else {
                    if (s.empty()) bw.write("고무오리야 사랑해" + "");
                    else bw.write("힝구" + "");
                    break;
                }
            }
            bw.flush();
        }
    }
}