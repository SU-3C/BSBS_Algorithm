package programmers;

import java.io.*;
import java.util.*;

class backjun {
    // 파이어볼 클래스 : 좌표(r, c), 질량(m), 속력(s), 방향(d), move()
    // 격자 칸 클래스 : 파이어볼 리스트(한 개의 격자 칸에 여러 개의 파이어볼이 존재할 수 있고, 이동이 끝난 후 리스트의 모든 파이어볼 요소는 한개로 합쳐진다.), merge(), split()
    // 방향(d) : 0(-1, 0), 1(-1, 1), 2(0, 1), 3(1, 1), 4(1, 0), 5(1, -1), 6(0, -1), 7(-1, -1)
    // r, c 격자의 파이어볼 리스트에 있는 요소들을 각 방향대로 이동 시킴 ( 칸 밖으로 넘어가면 반대편에서 등장 )
    //      -> 리스트에서 삭제하고 파이어볼 객체의 방향과 속력대로 이동 후 그 격자 칸의 리스트에 추가
    // 이동 중에 리스트에 새로운 요소가 들어올 수 있으니 각 격자 칸에서는 이동하기 전 리스트의 개수를 저장해놓아야 함.
    //      -> 즉 원래부터 있었던 파이어볼들만 이동시켜야 하고 이동 중에 들어온 파이어볼은 또 다시 이동시키면 안됨.
    // 1. 같은 격자 칸 안에 파이어볼이 2개 이상 존재할 경우
    //     2개 이상의 파이어볼은 1개로 합쳐지고 -> 해당 격차 칸의 리스트는 길이가 1이 됨.
    //     4개의 파이어볼로 나뉘어지고
    //     질량이 0인 파이어볼은 삭제된다.
    // 2. 각 4개의 파이어볼들의
    //    2-1. 질량은 질량의 합 / 5
    //    2-2. 속력은 속력의 합 / 파이어볼 개수
    //    2-3. 방향은
    //         2-3-1. 모두 짝수이거나 모두 홀수일 경우 : 0, 2, 4, 6
    //         2-3-2. 그렇지 않으면 : 1, 3, 5, 7
    //3. 질량이 0인 파이어볼은 삭제
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer in = null;
    static Cell[][] cells = null;
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int n=0, m=0, k=0;
    public static void main(String[] args) throws IOException {
        init();
        for (int q = 0; q < k; q++){
            for (int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if (cells[i][j].hasOldFireball()){
                        cells[i][j].moveFireball();
                    }
                }
            }
            for (int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if (cells[i][j].hasNewFireball()){
                        cells[i][j].mergeAndSplit();
                    }
                }
            }
        }
        finish();
    }

    static class Fireball{
        int r, c, m, s, d;
        Fireball(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
        void move(){
            r += dir[d][0]*s%n;
            c += dir[d][1]*s%n;
            fixPosition();
        }
        void fixPosition(){
            if (r > n-1) r -= n;
            else if (r < 0) r += n;
            if (c > n-1) c -= n;
            else if (c < 0) c += n;
        }
    }
    static class Cell{
        LinkedList<Fireball> oldFireball, newFireball;
        Cell() {
            oldFireball = new LinkedList<>();
            newFireball = new LinkedList<>();
        }
        void moveFireball(){
            for(Fireball f : oldFireball){
                f.move();
                cells[f.r][f.c].newFireball.add(f);
            }
            oldFireball.clear();
        }
        void mergeAndSplit() {
            if (newFireball.size() >= 2) {
                int newM = 0;
                int newS = 0;
                int cntNewFb = newFireball.size();
                int[][] newD = {{0, 2, 4, 6}, {1, 3, 5, 7}};
                int dirType = 0;
                boolean evenFlag = false;
                boolean oddFlag = false;
                for (Fireball f : newFireball) {
                    newM += f.m;
                    newS += f.s;
                    if (f.d % 2 == 0) evenFlag = true;
                    else oddFlag = true;
                }
                if (newM >= 5){
                    newM = (int) Math.floor(newM / 5.0);
                    newS = (int) Math.floor(newS / cntNewFb);
                    if (evenFlag && oddFlag) dirType = 1;
                    else dirType = 0;
                    Fireball f = newFireball.get(0);
                    newFireball.clear();
                    for (int i = 0; i < 4; i++) {
                        Fireball newF = new Fireball(f.r, f.c, newM, newS, newD[dirType][i]);
                        newFireball.add(newF);
                    }
                } else {
                    newFireball.clear();
                }
            }
            oldFireball.addAll(newFireball);
            newFireball.clear();
        }
        boolean hasOldFireball(){
            if (oldFireball.size() > 0) return true;
            else return false;
        }
        boolean hasNewFireball(){
            if (newFireball.size() > 0) return true;
            else return false;
        }
    }

    static void init() throws IOException{
        in = new StringTokenizer(br.readLine());
        n = Integer.parseInt(in.nextToken());
        m = Integer.parseInt(in.nextToken());
        k = Integer.parseInt(in.nextToken());
        cells = new Cell[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                cells[i][j] = new Cell();
            }
        }
        for (int i = 0; i < m; i++){
            in = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(in.nextToken()) - 1;
            int c = Integer.parseInt(in.nextToken()) - 1;
            int m = Integer.parseInt(in.nextToken());
            int s = Integer.parseInt(in.nextToken());
            int d = Integer.parseInt(in.nextToken());
            Fireball f = new Fireball(r, c, m, s, d);
            cells[r][c].oldFireball.add(f);
        }
    }

    static void finish() throws IOException {
        int sum = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(cells[i][j].hasOldFireball()) {
                    for (Fireball f : cells[i][j].oldFireball) {
                        sum += f.m;
                    }
                }
            }
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
