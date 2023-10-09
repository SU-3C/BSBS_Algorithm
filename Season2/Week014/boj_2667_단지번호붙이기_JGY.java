
import java.io.*;
import java.util.*;


/*

단지번호붙이기_2667

1. class danji : visited:boolean, hosu:int,
2. dfs 적용 - stack
3. apart[0][0]부터 방문처리 시작 -> visited = true; j++
4. 현재가 0이면 pass, 1(집)이면 인접한 노드 중 집만 stack에 push -> 인접은 상 하 좌 우 만
5. 1을 만나서 호수 지정을 했으면 인접한 모든 집들의 호수 지정이 끝날때까지 -> stack is empty까지 push와 pop & visit 수행
6. stack이 비었으면 다음 아파트 단지를 찾기 위해 3번으로 돌아가서 아까 멈추었던 집의 다음 집부터 순회 재시작

 */
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n = 0, maxDanjiNum = 1, danjiCnt = 0;
    static Danji[][] danji = null;
    static Stack<Danji> stack = null;
    static int[][] adjust = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        init();

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (danji[i][j].data == 1 && !danji[i][j].visit) {
                    stack.push(danji[i][j]);
                    while(!stack.isEmpty()){
                        stack.pop().visit();
                    }
                    list.add(danjiCnt);
                    danjiCnt = 0;
                    maxDanjiNum++;
                }
            }
        }

        bw.write(list.size() + "\n");
        list.sort(Comparator.naturalOrder());
        for(int i : list) bw.write(i + "\n");
        bw.flush();
        bw.close();
        //finish(0);

    }


    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        String[] in;
        danji = new Danji[n][n];
        for(int i = 0; i < n; i++){
            in = br.readLine().split("");
            for(int j = 0; j < n; j++){
                danji[i][j] = new Danji(Integer.parseInt(in[j]), i, j);
            }
        }
    }
    static void finish(int v) throws IOException {
        bw.write(v + "\n");
        bw.flush();
        bw.close();
    }

    static class Danji{
        int data, r, c;
        int hosu = 0;
        boolean visit = false;

        public Danji(int data, int r, int c){
            this.data = data;
            this.r = r;
            this.c = c;
        }

        void visit(){
            if (!visit){
                this.visit = true;
                this.hosu = maxDanjiNum;
                danjiCnt++;
            }
            int r, c;
            for(int[] ad : adjust){
                r = this.r + ad[0]; c = this.c + ad[1];
                if (r > -1 && r < n && c > -1 && c < n){
                    Danji d = danji[r][c];
                    if (d.data == 1 && !d.visit){
                        stack.push(d);
                    }
                }
            }
        }
    }
}
