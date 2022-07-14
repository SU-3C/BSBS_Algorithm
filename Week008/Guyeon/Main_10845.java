package week8;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 큐 문제 실버 4 큐 2 문제도 같이
public class Main_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> q = new LinkedList<>();
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        String in;
        for(int i=0;i<n;i++){
            in=br.readLine();
            st = new StringTokenizer(in);
            switch (st.nextToken()){
                case "push":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(q.isEmpty() ? "-1\n" : q.poll()+"\n" );
                    break;
                case "size":
                    bw.write(q.size()+"\n");
                    break;
                case "empty":
                    bw.write(q.isEmpty() ? "1\n" : "0\n" );
                    break;
                case "front":
                    bw.write(q.isEmpty() ? "-1\n" : q.peek()+"\n" );
                    break;
                case "back":
                    bw.write(q.isEmpty() ? "-1\n" : q.getLast()+"\n" );
                    break;
            }
        }
        bw.flush();
    }
}
