package week12;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7576 {
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int m = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);
        int day=0, cnt=0;
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(in[j]);
                if (b[i][j] == 1){
                    Node node = new Node(i, j, 0);
                    q.add(node);
                } else if (b[i][j] == 0){
                    cnt++;
                }
            }
        }
        while (!q.isEmpty()) {
            Node node = q.poll();
            int i = node.getI();
            int j = node.getJ();
            int d = node.getDay();
            if (b[i][j] == 2) {
                cnt--;
                b[i][j] = 9;
            }
            if (i+1 < n && b[i+1][j] == 0) { b[i+1][j] = 2; node = new Node(i+1, j, d+1); q.add(node); }
            if (j+1 < m && b[i][j+1] == 0) { b[i][j+1] = 2; node = new Node(i, j+1, d+1); q.add(node); }
            if (i-1 > -1 && b[i-1][j] == 0) { b[i-1][j] = 2; node = new Node(i-1, j, d+1); q.add(node); }
            if (j-1 > -1 && b[i][j-1] == 0) { b[i][j-1] = 2; node = new Node(i, j-1, d+1); q.add(node); }
            if(day < d){
                day++;
            }
        }
        if(cnt!=0) bw.write("-1");
        else bw.write(day + "");
        bw.flush();
    }
}
class Node{
    private int i, j, day;
    public Node(int i, int j, int day) {
        this.i = i;
        this.j = j;
        this.day = day;
    }
    public int getI() {
        return i;
    }
    public int getJ() {
        return j;
    }
    public int getDay() {
        return day;
    }
}