package week11;

import java.io.*;
import java.util.*;

public class Main_2178 {
    static int[][] map;
    static int N, M;
    static Queue<Node> q=new LinkedList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        map = new int[N][M];
        for(int i = 0; i<N; i++){
            in[0] = br.readLine();
            for(int j = 0; j<M; j++){
                map[i][j] = in[0].charAt(j)-'0';
            }
        }
//        bw.write(list.stream().min(Comparator.naturalOrder()).get() + "");
        Node n = new Node(0, 0, 1);
        bfs(n);
        bw.flush();
    }
    static void bfs(Node n) throws IOException {
        int i = n.getI();
        int j = n.getJ();
        int depth = n.getDepth();
        if (i == N - 1 && j == M - 1) {
            bw.write(depth + "");
            return;
        }
        map[i][j] = depth;
        Node node;
        if (i+1 < N && map[i+1][j] == 1) { node = new Node(i+1, j, depth+1); q.add(node); }
        if (j+1 < M && map[i][j+1] == 1) { node = new Node(i, j+1, depth+1); q.add(node); }
        if (i-1 > -1 && map[i-1][j] == 1) { node = new Node(i-1, j, depth+1); q.add(node); }
        if (j-1 > -1 && map[i][j-1] == 1) { node = new Node(i, j-1, depth+1); q.add(node); }

        try{
            while(true){
                node = q.poll();
                if( map[node.getI()][node.getJ()] == 1 ){
                    break;
                }
            }
            bfs(node);
        } catch (Exception e){
            return;
        }
    }
}
class Node{
    private int i, j, depth;
    public Node(int i, int j, int depth) {
        this.i = i;
        this.j = j;
        this.depth = depth;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getDepth() {
        return depth;
    }
}


//    int i=0, j=0, cnt = 1, direction=0;
//        while(true){
//                if (i+1 < N && map[i+1][j] == 1) { map[i][j]=direction=3; i++; }
//        else if (j+1 < M && map[i][j+1] == 1) { map[i][j]=direction=2; j++; }
//        else if (i-1 > -1 && map[i-1][j] == 1) { map[i][j]=direction=4; i--; }
//        else if (j-1 > -1 && map[i][j-1] == 1) { map[i][j]=direction=5; j--; }
//        else {
//        map[i][j] = 0;
//        if (direction == 2) j--;
//        else if (direction == 3) i--;
//        else if (direction == 4) i++;
//        else j++;
//        direction = map[i][j];
//        cnt--;
//        continue;
//        }
//        cnt++;
//        if (i==N-1 && j==M-1) break;
//        }