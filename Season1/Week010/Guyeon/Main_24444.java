package week10;

import java.io.*;
import java.util.*;

public class Main_24444 {
    static boolean[] visited;
    static Queue<Integer> q;
    static Set<Integer>[] ll;
    static int[] seqArr;
    static int seq=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int R = Integer.parseInt(in[2]);
        seqArr = new int[N+1];
        ll = new Set[N + 1];
        visited = new boolean[N + 1];
        q = new LinkedList<>();
        for (int i=1;i<N+1;i++){
            ll[i] = new TreeSet<>();
        }
        for(int i=0; i<M; i++){
            in = br.readLine().split(" ");
            int in1 = Integer.parseInt(in[0]);
            int in2 = Integer.parseInt(in[1]);
            ll[in1].add(in2);
            ll[in2].add(in1);
        }
        bfs(R);
        for (int i=1;i<N+1;i++){
            bw.write(seqArr[i]+"\n");
        }
        bw.flush();
    }

    static void bfs(int start) {
        seqArr[start] = ++seq;
        visited[start] = true;
        for(int i : ll[start]){
            if (!visited[i])
                q.add(i);
        }
        try{
            int next;
            while( visited[next=q.poll()] );
            bfs(next);
        }catch (NullPointerException e){
            return;
        }
    }
}