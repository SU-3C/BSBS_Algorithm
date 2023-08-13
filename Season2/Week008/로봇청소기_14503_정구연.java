package programmers;

import java.io.*;

class backjun {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        in = br.readLine().split(" ");
        int r = Integer.parseInt(in[0]);
        int c = Integer.parseInt(in[1]);
        int d = Integer.parseInt(in[2]);
        int[][] map = new int[n][m];
        int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        for (int i = 0; i < n; i++){
            in = br.readLine().split(" ");
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        while (true) {
            // 방 청소하기
            map = cleanRoom(map, r, c);
            // 주변에 청소 안된 방이 있는지 확인 
            if (checkAroundRoom(map, r, c, dir)) { // 청소 안된 방이 있다면 
                d = (d == 0) ? 3 : d - 1;  // 반시계 방향 90도 회전
                if (map[r + dir[d][0]][c + dir[d][1]] == 0) { // 앞 칸이 청소가 안되었다면 전진
                    r += dir[d][0];
                    c += dir[d][1];
                }
            } else {  // 청소 안된 방이 없다면
                int tempD = (d > 1)?d - 2 : d + 2; // 후진 방향 설정
                if (map[r + dir[tempD][0]][c + dir[tempD][1]] == 1) { // 벽이라면 출력하고 종료
                    bw.write(cnt + "\n");
                    bw.flush();
                    bw.close();
                    return;
                } else {  // 벽이 아니라면 후진
                    r += dir[tempD][0];
                    c += dir[tempD][1];
                }
            }
        }
    }

    static int[][] cleanRoom(int[][] map, int r, int c){
        if (map[r][c] == 0) {
            map[r][c] = 2;
            cnt++;
        }
        return map;
    }
    static boolean checkAroundRoom(int[][] map, int r, int c, int[][] dir){
        for(int i = 0; i < dir.length; i++){
            if (map[r + dir[i][0]][c + dir[i][1]] == 0) return true;
        }
        return false;
    }

}