import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면
 * T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.
 * 대기실은 5개이며, 각 대기실은 5x5 크기입니다.
 * 거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
 * 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
 * 거리를 지킬시 1 아니면 0 출력
 * <p>
 * 2차원 배열 탐색을 돌다 P(사람이 앉은)위치가 나오면 너비 우선 탐색으로 한칸씩 탐색하여 값을 집어 넣는다.
 * 1. 사방이 파티션(X)으로 가둬지거나 탐색을 다 했을 경우 (큐에 더 이상 진행할 수가 없을 경우) 에는 안전하다라는 판단을 하고 다음 탐색으로 넘어간다.
 * 2. 파티션이 하나가 있거나 없는 경우 탐색을 진행한다. 만약 거리가 2 이내에서 P가 탐색이 되었을경우 맨허튼 거리를 구하는 식을 적용하고 2보다 작을 경우 0을 반환하고 종료한다.
 */
public class CheckDistancing {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean[][] visited;

    public static void main(String[] args) {

        CheckDistancing checkDistancing = new CheckDistancing();
        String[][] places =  {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] solution = checkDistancing.solution(places);

        for (int answer : solution) {
            System.out.print(answer + " ");
        }

    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        String[][] map;
        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            map = new String[5][5];
            String[] parsingStr = places[i];
            for (int j = 0; j < 5; j++) {
                String[] split = parsingStr[j].split("");
                for (int k = 0; k < 5; k++) {
                    map[j][k] = split[k];
                }
            }

            int tmp = 1;
            visited = new boolean[5][5];
            for (int g = 0; g < 5; g++) {
                queue.clear();
                for (int h = 0; h < 5; h++) {
                    if (map[g][h].equals("P")) {
                        visited[g][h] = true;
                        queue.add(new Position(g, h, 0));
                        int r = 0, c = 0;
                        while (!queue.isEmpty()) {
                            Position poll = queue.poll();

                            if (poll.distance == 3) {
                                break;
                            }

                            r = poll.r;
                            c = poll.c;
                            poll.distance++;

                            for (int k = 0; k < 4; k++) {
                                int nr = r + dy[k];
                                int nc = c + dx[k];
                                if (nc >= 0 && nc < 5 && nr >= 0 && nr < 5) {
                                    if (map[nr][nc].equals("O")) {
                                        queue.add(new Position(nr, nc, poll.distance));
                                    } else if (!visited[nr][nc] && map[nr][nc].equals("P")) {
                                        if (poll.distance < 3) {
                                            tmp = 0;
                                            queue.clear();
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = tmp;

        }
        return answer;
    }

    static class Position {
        int r;
        int c;
        int distance;

        public Position(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }
}
