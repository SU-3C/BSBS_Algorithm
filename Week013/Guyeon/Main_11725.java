package week13;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_11725{
    static List<Integer>[] g;
    static int[] res;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        g = new ArrayList[n+1];
        res = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            g[i] = new ArrayList<Integer>();
        }
        String[] in;
        for (int i = 1; i < n; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            g[a].add(b);
            g[b].add(a);
        }
        recur(1);
        for (int i = 2; i < n + 1; i++) {
            bw.write(res[i]+"\n");
        }
        bw.flush();
    }

    static void recur(int start) {
        visited[start] = true;
        for(int i : g[start]){
            if (!visited[i]){
                res[i] = start;
                q.add(i);
            }
        }
        if(!q.isEmpty()) recur(q.poll());
    }
}
