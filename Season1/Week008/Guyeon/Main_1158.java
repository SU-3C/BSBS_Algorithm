package week8;

import java.io.*;
import java.util.LinkedList;

public class Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> q = new LinkedList<>();
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int K = Integer.parseInt(in[1]);
        bw.write("<");
        for(int i=0; i<N; i++, q.add(i));
        int i=0;
        for(int j=0;j<N;j++){
            i+=(K-1);
            int size = q.size();
            if(i >= size)
                i=i%size;
            bw.write(q.remove(i) + ((j<N-1) ? ", ":""));
        }
        bw.write(">");
        bw.flush();
    }
}

