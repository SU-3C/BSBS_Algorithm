package week10;

import java.io.*;
import java.util.*;

// DFS와 BFS 문제
public class Main_1260 {
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer>[] ll;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int V = Integer.parseInt(in[2]);
        ll = new LinkedList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            ll[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int in1 = Integer.parseInt(in[0]);
            int in2 = Integer.parseInt(in[1]);
            ll[in1].add(in2);
            ll[in2].add(in1);
        }
        for(int i=0;i<N+1;i++){
            ll[i].sort(Comparator.naturalOrder());
        }
        visited = new boolean[N + 1];
        dfs(V);
        bw.write("\n");
        visited = new boolean[N + 1];
        bfs(V);
        bw.flush();
    }

    static void dfs(int start) throws IOException {
        bw.write(start+" ");
        visited[start] = true;
        for(int i : ll[start]){
            if (!visited[i])
                dfs(i);
        }
    }

    static void bfs(int start) throws IOException {
        bw.write(start+" ");
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

//public class Main_1260 {
//    static Stack<Integer> s = new Stack<>();
//    static Queue<Integer> q1 = new LinkedList<>();
//    static Queue<Integer> q2 = new LinkedList<>();
//    static Set<Integer>[] ll;
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] in = br.readLine().split(" ");
//        int N = Integer.parseInt(in[0]);
//        int M = Integer.parseInt(in[1]);
//        int V = Integer.parseInt(in[2]);
//        ll = new Set[N + 1];
//        for (int i = 0; i < N + 1; i++) {
//            ll[i] = new TreeSet<>();
//        }
//        for (int i = 0; i < M; i++) {
//            in = br.readLine().split(" ");
//            int in1 = Integer.parseInt(in[0]);
//            int in2 = Integer.parseInt(in[1]);
//            ll[in1].add(in2);
//            ll[in2].add(in1);
//        }
//        dfs(V);
//        bw.write("\n");
//        bfs(V);
//        bw.flush();
//    }
//
//    static void dfs(int start) throws IOException {
//        if (s.contains(start)) return;
//        bw.write(start+" ");
//        s.add(start);
//        for(int i : ll[start]){
//            dfs(i);
//        }
//    }
//
//    static void bfs(int start) throws IOException {
//        if (q1.contains(start)) return;
//        bw.write(start+" ");
//        q1.add(start);
//        for(int i:ll[start]){
//            if (!q1.contains(i) && !q2.contains(i)) {
//                q2.add(i);
//            }
//        }
//        try{
//            bfs(q2.poll());
//        }catch (NullPointerException e){
//            return;
//        }
//    }
//}

//public class Main {
////    public static void main(String[] args) throws Exception {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
////
////        bw.flush();
////    }
//
//    // 방문처리에 사용 할 배열선언
//    static boolean[] vistied = new boolean[9];
//
//    // 그림예시 그래프의 연결상태를 2차원 배열로 표현
//    // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
//    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
//
//    public static void main(String[] args) {
//        dfs(1);
//    }
//
//    static void dfs(int nodeIndex) {
//        // 방문 처리
//        vistied[nodeIndex] = true;
//
//        // 방문 노드 출력
//        System.out.print(nodeIndex + " -> ");
//
//        // 방문한 노드에 인접한 노드 찾기
//        for (int node : graph[nodeIndex]) {
//            // 인접한 노드가 방문한 적이 없다면 DFS 수행
//            if (!vistied[node]) {
//                dfs(node);
//            }
//        }
//    }
//}