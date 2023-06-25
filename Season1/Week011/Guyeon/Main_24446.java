package week11;

import java.io.*;
import java.util.*;

public class Main_24446 {
    static boolean[] visited;
    static Queue<Integer> q;
    static List<Integer>[] ll;
    static int[] depthArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int R = Integer.parseInt(in[2]);
        depthArr = new int[N + 1];
        ll = new List[N + 1];
        visited = new boolean[N + 1];
        q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            ll[i] = new ArrayList<>();
            depthArr[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int in1 = Integer.parseInt(in[0]);
            int in2 = Integer.parseInt(in[1]);
            ll[in1].add(in2);
            ll[in2].add(in1);
        }
        for (int i = 1; i < N + 1; i++) {
            ll[i].sort(Comparator.naturalOrder());
        }
        depthArr[R] = 0;
        bfs(R);
        for (int i = 1; i < N + 1; i++) {
            bw.write(depthArr[i] + "\n");
        }
        bw.flush();
    }

    static void bfs(int start) {
        visited[start] = true;
        for (int i : ll[start]) {
            if (!visited[i]) {
                q.add(i);
            }
            if (depthArr[i] == -1) {
                depthArr[i] = depthArr[start] + 1;
            }
        }
        try {
            int next;
            while (visited[next = q.poll()]) ;
            bfs(next);
        } catch (NullPointerException e) {
            return;
        }
    }
}