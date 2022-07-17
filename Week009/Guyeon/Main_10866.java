package week8;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> dq = new ArrayDeque<>();
        int n=Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push_front":
                    dq.addFirst(st.nextToken());
                    break;
                case "push_back":
                    dq.addLast(st.nextToken());
                    break;
                case "pop_front":
                    bw.write( (dq.isEmpty())?"-1\n":dq.poll()+"\n");
                    break;
                case "pop_back":
                    bw.write( (dq.isEmpty())?"-1\n":dq.pollLast()+"\n");
                    break;
                case "size":
                    bw.write(dq.size()+"\n");
                    break;
                case "empty":
                    bw.write( (dq.isEmpty())?"1\n":"0\n");
                    break;
                case "front":
                    bw.write((dq.isEmpty())?"-1\n":dq.getFirst()+"\n");
                    break;
                case "back":
                    bw.write((dq.isEmpty())?"-1\n":dq.getLast()+"\n");
                    break;
            }
        }
        bw.flush();
    }
}