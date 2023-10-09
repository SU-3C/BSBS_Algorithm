import java.io.*;
import java.util.*;

/**
 * DFS로 class를 만들어 기록을 할 예정이다.
 * 첫번째 그래프로 인접한 요소에 대한 링크를 시키는것이 첫번째 해결
 * - 탐색을 진행 할때 처음 나온 곳부터 상하좌우를 탐색하여 만약 앞에 1이있으면 연결 그리고 재귀로 다음으로 넘어감 그리고 answer에 ++ 진행
 * - 예를들어 2,2에서 탐색을 시작할때 1,2 3,2 ,2,1 2 3 을 탐색하여 data에 값이 1 이 있다면 재귀로 해당 탐색을 진행
 * - 모든 탐색이 끝났다면 다시 반복을 돌려 탐색하지 않았고 1인곳을 탐색함 그때는 이제 2로 시작 또 탐색이 끝나면 3... n++로 반복하여 진행
 * - 다음 배열로 이동 한번 탐색한곳은 다시 탐색하지 않도록 visited를 두어 넘어갑니다.
 * 왜냐면 속도떄문에 문제가 생길 수 있는 염려가 있다고 생각함
 */
public class NumberingDanzi {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Node[][] nodeMap;

    static int T;
    static int linkedCnt;

    public static void main(String[] args) throws IOException {
        List<Integer> answer = new ArrayList<>();


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bf.readLine());

        nodeMap = new Node[T][T];

        for (int i = 0; i < T; i++) {
            String[] split = bf.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                nodeMap[i][j] = new Node(Integer.parseInt(split[j]));
            }
        }


        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                linkedCnt = 0;
                if (!nodeMap[i][j].visited && nodeMap[i][j].data == 1) {
                    linkedCnt++;
                    DFS(j, i);
                    nodeMap[i][j].visited = true;
                    answer.add(linkedCnt);
                }
            }
        }
        Collections.sort(answer);
        bw.write(answer.size()+"\n");
        for (Integer i : answer) {
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();

    }

    static public void DFS(int x, int y) {
        if (nodeMap[y][x].data == 0 || nodeMap[y][x].visited) return;
        else {
            nodeMap[y][x].visited = true;
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + x;
                int ny= dy[k] + y;
                if (nx >= 0 && nx < T && ny >= 0 && ny < T &&  nodeMap[ny][nx].data == 1&& !nodeMap[ny][nx].visited) {
                    linkedCnt++;
                    DFS(nx, ny);
                }
            }
        }
    }

}

class Node {
    public int data;
    public boolean visited;

    public Node(int data) {
        this.data = data;
        this.visited = false;
    }

}
