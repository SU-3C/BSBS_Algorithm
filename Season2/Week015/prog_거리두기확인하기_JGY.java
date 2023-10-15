/*
현재 자리가 P 일때 사방 탐색
  -> X이면 탐색을 안해도 돼

P이면 바로 종료
O면 그 자리에서 사방 탐색 ( 거리가 2이하인 자리만 탐색)

대기실 모든 자리 탐색 완료면 1
중간에 실패면 0

*/


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Queue<Position> q = null;
    boolean[][] visit = null;
    short[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    String[][] places = null;
    int[] answer = new int[5];
    int seq = 0;
    boolean isFail = false;
    public int[] solution(String[][] places) {
        visit = new boolean[5][5];
        q = new LinkedList<>();
        this.places = places;
        for(seq = 0; seq < 5; seq++){
            for (int i = 0; i < 5 && !isFail; i++){
                for (int j = 0; j < 5 && !isFail; j++) {
                    if (places[seq][i].charAt(j) == 'P'){
                        q.add(new Position(i, j, 0));
                        visit[i][j] = true;
                        bfs();
                    }
                }
            }
            if (!isFail)
                answer[seq] = 1;
            else answer[seq] = 0;
            isFail = false;
            clearVisit();
        }
        return answer;
    }

    void bfs(){
        int r, c;
        while(!q.isEmpty()){
            Position p = q.poll();
            for(short[] dir : dirs){
                r = p.r + dir[0];
                c = p.c + dir[1];
                if (checkDirection(r, c)){
                    if (places[seq][r].charAt(c) == 'P'){
                        q.clear();
                        isFail = true;
                        return;
                    } else if (places[seq][r].charAt(c) == 'O'){
                        if (p.dist < 1)
                            q.add(new Position(r, c, p.dist+1));
                    } else {
                        continue;
                    }
                }
            }
        }
    }
    boolean checkDirection(int r, int c){
        if (r > -1 && r < 5 && c > -1 && c < 5 && !visit[r][c]) return true;
        return false;
    }
    class Position {
        int r, c, dist;
        Position(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    void clearVisit(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                visit[i][j] = false;
            }
        }
    }
}

public class Programmers {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] array = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        for(int i : sol.solution(array)){
            System.out.println(i);
        }
    }
}
