import java.util.Scanner;

public class RobotCleaner {

    //0 : 북 , 1 : 동 , 2 : 남 , 3 : 서
    public static int[][] positionView = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int answer = 0;
        boolean isContinue = true;
        int[][] cleanMap = new int[N][M];
        for (int i = 0; i < cleanMap.length; i++) {
            for (int j = 0; j < cleanMap[i].length; j++) {
                cleanMap[i][j] = sc.nextInt();
            }
        }

        boolean isBlank;
        while (isContinue) {
            isBlank = false;

            // 1. 로봇 위치에 따른 값 추가 해주기
            if (cleanMap[r][c] == 0) {
                cleanMap[r][c] = 2;
                answer++;
            }

            // 3. 빈칸이 있는 경우
            for (int k = 0; k < 4; k++) {
                int nx = r + positionView[k][0];
                int ny = c + positionView[k][1];
                if (cleanMap[nx][ny] == 0) {
                    //반시계
                    d--;
                    if (d < 0) d = 3;
                    nx = r + positionView[d][0];
                    ny = c + positionView[d][1];
                    if (cleanMap[nx][ny] == 0) {
                        r = nx;
                        c = ny;
                    }
                    isBlank = false;
                    break;
                }
                isBlank = true;
            }

            int nd = 0;
            // 2.없는 경우
            if (isBlank) {
                nd = (d + 2) % 4;
                int backX = r + positionView[nd][0];
                int backY = c + positionView[nd][1];

                if (cleanMap[backX][backY] == 1) {
                    isContinue = false;
                } else {
                    r = backX;
                    c = backY;
                }
            }
        }
        System.out.println(answer);
    }


}
