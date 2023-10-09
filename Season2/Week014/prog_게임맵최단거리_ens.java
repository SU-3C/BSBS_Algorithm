import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * class는 bool isWall 과 list<Node>를 사용하여 인접한 값이 있는지 확인 합니다.
 * 5x5 배열 캐릭터가 움직일땐 동서남북 방향으로 한칸씩 이동합니다.
 * (0,1)로 되어있으며 1은 지나갈수 있고 0은 벽입니다.
 * 벗어난 길은 갈 수가 없습니다.
 * 도달할 수 없으면 -1로 반환합니다.
 * - 해당 경우는 보석이 좌표에 0으로 막혀있으면 -1 처리를 진행하면 될꺼같다.
 * 4방 탐색을 진행했을때 인접한 방향이 0(true)면 못가고 false면 Queue에 담습니다.
 * 2개에 대한 도달한 값에 대한 값을 list에 저장하고 최솟값을 반환합니다.
 */
class GameMapShortDistance {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean[][] visited;

    public static void main(String[] args) {
        GameMapShortDistance gameMapShortDistance = new GameMapShortDistance();
        int[][] maps = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};
        int answer = gameMapShortDistance.solution(maps);
        System.out.println(answer);
    }

    public int solution(int[][] maps) {
        int x = 0, y = 0;
        Queue<Position> route = new LinkedList<>();
        route.add(new Position(0, 0,0));
        visited[0][0] = true;
        while (!route.isEmpty()) {

            Position poll = route.poll();
            poll.distance++;
            x = poll.x;
            y = poll.y;

            if (x == maps[0].length-1 && y == maps.length-1) {
                return poll.distance;
            } else {
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < maps[0].length && ny >= 0 && ny < maps.length && maps[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        route.add(new Position(nx, ny,poll.distance));
                    }
                }
            }
        }
        return -1;
    }
    class Position {
        int x;
        int y;
        int distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}



