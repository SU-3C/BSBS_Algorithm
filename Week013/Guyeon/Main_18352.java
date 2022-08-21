package week13;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class Main_18352{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int N = parseInt(in[0]), M = parseInt(in[1]), K = parseInt(in[2]), X = parseInt(in[3]);

        List<Integer>[] road = new ArrayList[N + 1];
        boolean[] res = new boolean[N + 1];
        boolean flag = false;
//        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N+1; i++) {
            road[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int a = parseInt(in[0]), b = parseInt(in[1]);
            road[a].add(b);
        }
        int depth = 0, cur=1;

        q.add(X);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                cur = q.poll();
                if(visited[cur]) continue;
                visited[cur] = true;
                if (depth == K) {
                    res[cur] = true;
                    flag = true;
                    continue;
                }
                for(int j : road[cur]){
                    q.add(j);
                }
            }
            depth++;
        }
        if(!flag) bw.write("-1");
        else {
//            res.sort(Integer::compareTo);
            for (int i=0;i<res.length;i++) {
                if (res[i])
                    bw.write(i+"\n");
            }
        }
        bw.flush();
    }
}