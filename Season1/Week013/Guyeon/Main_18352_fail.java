package week13;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class Main_18352_fail{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int N = parseInt(in[0]), M = parseInt(in[1]), K = parseInt(in[2]), X = parseInt(in[3]);

        List<Integer>[] g = new ArrayList[N + 1];
        int[] res = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 1; i < N+1; i++) {
            g[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int a = parseInt(in[0]);
            int b = parseInt(in[1]);
            g[a].add(b);
        }
//        for (int j = 1; j < N+1; j++) {
//            bw.write(j + " : ");
//            for (int i : g[j]) {
//                bw.write(i + " ");
//            }
//            bw.write("\n");
//        }
//        bw.write("---------------------\n");
        int cnt = 0, depth = 0, cur;

        q.add(X);
        while (!q.isEmpty()) {
            cur = q.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            res[cur] = depth;
            if (res[cur] == K) cnt++;
            for(int j : g[cur]){
                q2.add(j);
//                bw.write(j + " ");
            } /*bw.write("\n");*/
            if (q.isEmpty()){
                q = q2;
                q2 = new LinkedList<>();
                depth++;
            }
        }
//        bw.write("---------------------\n");
//        for (int i = 1; i < N + 1; i++) {
//            bw.write(i + " : " + res[i] + "\n");
//        }
//        bw.write("---------------------\n");
        if (cnt == 0) bw.write("-1");
        else {
            for (int i = 1; i < N + 1; i++) {
                if(res[i] == K)
                    bw.write(i+"\n");
            }
        }
        bw.flush();
    }
}