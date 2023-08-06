
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        List<Integer> list = new LinkedList<>();
        List<Integer> rIdx = new LinkedList<>();
        in = br.readLine().split(" ");
        for(int i = 0; i < in.length; i++) {
            list.add(Integer.parseInt(in[i]));
        }

        int cnt = 0;
        int kCnt = 0;
        while (kCnt < k) {
            kCnt = 0;
            // 컨베이어 벨트와 로봇을 1칸씩 이동
            list.add(0, list.remove(list.size() - 1));
            for (int i = 0; i < rIdx.size(); i++) {
                rIdx.set(i, rIdx.get(i) + 1);
            }
            // 내리는 위치에 있는 것 내리기
            if (rIdx.indexOf(n-1) > -1)
                rIdx.remove((Object) (n-1));

            // 로봇 1칸 움직일 수 있으면 움직이기
            for (int i = 0; i < rIdx.size(); i++) {
                int next = rIdx.get(i) + 1;
                if (rIdx.indexOf(next) == -1 && list.get(next) > 0 ) {
                    rIdx.set(i, next);
                    list.set(next, list.get(next) - 1);
                }
            }
            // 내리는 위치에 있는 것 내리기
            if (rIdx.indexOf(n-1) > -1)
                rIdx.remove((Object) (n-1));

            // 올리는 위치에 내구도 0 이상이면 로봇 추가
            if (list.get(0) > 0 && rIdx.indexOf(0) == -1) {
                rIdx.add(0);
                list.set(0, list.get(0) - 1);
            }

            for(int i : list) {
                if (i == 0)
                    kCnt++;
            }
            cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
