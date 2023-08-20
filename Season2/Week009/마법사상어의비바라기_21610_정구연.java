package programmers;

import java.io.*;
import java.util.*;

class backjun {
    static BufferedReader br = null;
    static BufferedWriter bw = null;
    static StringTokenizer in = null;
    static int n=0, m=0;
    static Bucket[][] buckets = null;
    static int[][] dir = null;
    static List<Cloud> clist = null;
    public static void main(String[] args) throws IOException {
        init();
        int d = 0, s = 0;
        int i = 0;
        for(i = 0; i < m; i++){
            in = new StringTokenizer(br.readLine());
            d = Integer.parseInt(in.nextToken())-1;
            s = Integer.parseInt(in.nextToken());
            moveCloud(dir[d][0] * s, dir[d][1] * s);
            rainism();
            checkOutline();
            createCloud();
        }
        finish(getScore());
    }
    static void moveCloud(int r, int c){
        for (Cloud cloud : clist){
            cloud.move(r, c);
            buckets[cloud.r][cloud.c].isCloud = true;
        }
    }
    static void rainism(){
        for (Cloud cloud : clist){
            buckets[cloud.r][cloud.c].water++;
        }
    }
    static void checkOutline(){
        int cnt = 0, r = 0, c = 0, i = 0;
        for(Cloud cloud : clist){
            cnt = 0;
            for(i = 0; i < 4; i++){
                r = dir[i*2 + 1][0];
                c = dir[i*2 + 1][1];
                if (cloud.r + r > -1 && cloud.r + r < n && cloud.c + c > -1 && cloud.c + c < n){
                    if (buckets[cloud.r + r][cloud.c + c].water > 0){
                        cnt++;
                    }
                }
            }
            buckets[cloud.r][cloud.c].water += cnt;
        }
    }
    static void createCloud(){
        clist.clear();
        int i = 0, j = 0;
        for(i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                if (!buckets[i][j].isCloud){
                    if (buckets[i][j].water >= 2){
                        buckets[i][j].water -= 2;
                        clist.add(new Cloud(i, j));
                    }
                } else {
                    buckets[i][j].isCloud = false;
                }
            }
        }
    }
    static int getScore(){
        int answer = 0, i = 0, j = 0;
        for(i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                answer += buckets[i][j].water;
            }
        }
        return answer;
    }
    static void init() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = new StringTokenizer(br.readLine());
        n = Integer.parseInt(in.nextToken());
        m = Integer.parseInt(in.nextToken());
        buckets = new Bucket[n][n];
        int i = 0, j = 0;
        for (i = 0; i < n; i++){
            in = new StringTokenizer(br.readLine());
            for (j = 0; j < n; j++){
                buckets[i][j] = new Bucket(Integer.parseInt(in.nextToken()));
            }
        }
        dir = new int[][]{{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        clist = new ArrayList<>();
        clist.add(new Cloud(n-2, 0));
        clist.add(new Cloud(n-2, 1));
        clist.add(new Cloud(n-1, 0));
        clist.add(new Cloud(n-1, 1));
    }

    static void finish(int answer) throws IOException {
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static class Bucket {
        int water;
        boolean isCloud = false;
        Bucket(int water){
            this.water = water;
        }
    }

    static class Cloud {
        int r;
        int c;
        Cloud(int r, int c){
            this.r = r;
            this.c = c;
        }
        void move(int r, int c){
            this.r += (r%n);
            this.c += (c%n);
            fixPos();
        }
        void fixPos(){
            if (r > n-1) r -= n;
            if (r < 0) r += n;
            if (c > n-1) c -= n;
            if (c < 0) c += n;
        }
    }
}
