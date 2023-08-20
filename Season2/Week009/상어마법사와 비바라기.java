import java.util.*;

public class SorcererSharkAndViva {

    public static Map<Integer, int[]> cross = new HashMap<>();
    static List<CloudPosition> cloudPositions = new ArrayList<>();

    static int[][] rainArea = null;
    static boolean[][] cloudArea = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        rainArea = new int[N][N];

        cloudArea = new boolean[N][N];

        for (int i = 0; i < rainArea.length; i++) {
            for (int j = 0; j < rainArea[i].length; j++) {
                rainArea[i][j] = sc.nextInt();
            }
        }

        //구름 초기화
        initCloud(N);

        for (int i = 0; i < M; i++) {
            int di = sc.nextInt();
            int si = sc.nextInt();
            movedCloud(N, di, si);



            searchBucket(rainArea, N);

            //전체 탐색하여 구름을 생성하는 메서드
            createCloud(rainArea, cloudArea);
            cloudPositions.clear();
            for (int j = 0; j < cloudArea.length; j++) {
                for (int k = 0; k < cloudArea.length; k++) {
                    if (cloudArea[j][k]) {
                        cloudArea[j][k] = false;
                        cloudPositions.add(new CloudPosition(j, k));
                    }
                }
            }
        }

        //합해주는 메서드
        sumCloudPos(rainArea);
    }


    private static void movedCloud(int N, int di, int si) {

        for (int j = 0; j < cloudPositions.size(); j++) {
            int processCnt = 0;
            int[] movePos = cross.get(di);
            CloudPosition cloudPosition = cloudPositions.get(j);
            int posX = cloudPosition.getX();
            int posY = cloudPosition.getY();
            while (processCnt < si) {
                int moveX = movePos[0];
                int moveY = movePos[1];
                posX = posX + moveX;
                posY = posY + moveY;
                //넘어갈 때 처리
                if (posX >= N) {
                    posX = 0;
                }
                if (posX < 0) {
                    posX = N - 1;
                }
                if (posY >= N) {
                    posY = 0;
                }
                if (posY < 0) {
                    posY = N - 1;
                }
                processCnt++;
            }
            rainArea[posX][posY]++;
            cloudArea[posX][posY] = true;
            cloudPosition.setX(posX);
            cloudPosition.setY(posY);
            cloudPositions.set(j, cloudPosition);
        }

    }

    private static void searchBucket(int[][] rainArea, int N) {
        for (CloudPosition cloudPosition : cloudPositions) {
            int posX = cloudPosition.getX();
            int posY = cloudPosition.getY();
            for (int k = 2; k <= 8; k = k + 2) {
                int[] crossPos = cross.get(k); // 대각선 깨내오는거
                int navX = posX + crossPos[0];
                int navY = posY + crossPos[1];
                if (navY >= 0 && navY < N && navX >= 0 && navX < N && rainArea[navX][navY] > 0) {
                    rainArea[posX][posY] = rainArea[posX][posY] + 1;
                }
            }
        }
    }

    //전체 탐색하여 구름을 생성하는 메서드
    private static void createCloud(int[][] rainArea, boolean[][] cloudArea) {
        for (int i = 0; i < rainArea.length; i++) {
            for (int j = 0; j < rainArea[i].length; j++) {
                if (cloudArea[i][j]) {
                    cloudArea[i][j] = false;
                } else if (!cloudArea[i][j] && rainArea[i][j] > 1) {
                    cloudArea[i][j] = true;
                    rainArea[i][j] = rainArea[i][j] - 2;
                }
            }

        }
    }

    //구름 위치 및 구름 방향 초기화 메서드
    private static void initCloud(int N) {

        cloudPositions.add(new CloudPosition(N - 1, 0));
        cloudPositions.add(new CloudPosition(N - 1, 1));
        cloudPositions.add(new CloudPosition(N - 2, 0));
        cloudPositions.add(new CloudPosition(N - 2, 1));


        cross.put(1, new int[]{0, -1});
        cross.put(2, new int[]{-1, -1});//대각
        cross.put(3, new int[]{-1, 0});
        cross.put(4, new int[]{-1, 1});//대각
        cross.put(5, new int[]{0, 1});
        cross.put(6, new int[]{1, 1});//대각
        cross.put(7, new int[]{1, 0});
        cross.put(8, new int[]{1, -1});//대각
    }

    private static void sumCloudPos(int[][] rainArea) {
        int answer = 0;
        for (int[] ints : rainArea) {
            for (int anInt : ints) {
                answer += anInt;
            }
        }
        System.out.println(answer);
    }

    //구름 객체 좌표
    static class CloudPosition {
        int x;
        int y;

        public CloudPosition() {

        }

        public CloudPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
