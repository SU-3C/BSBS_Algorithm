package programmers;

import java.io.*;
import java.util.*;

/*
칭호, 전투력 정보를 배열에 저장.

1. 사용자 전투력이 들어옴
2. 전투력 배열의 가운데 요소 값을 사용자 전투력과 비교
    2-0. 탐색할 범위의 시작점과 끝점을 갱신해가며 탐색
    2-1. 작으면 왼쪽 끝부터 현재 인덱스 -1 사이의 배열에서 2로
    2-2. 크면 현재 인덱스 + 1부터 오른쪽 끝 사이의 배열에서 2로
3. 왼쪽 끝 또는 오른쪽 끝과 현재 인덱스의 +- 1 한 값이 같으면 해당 idx 값의 칭호 출력

 */
class backjun {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer in = null;
    static int n = 0, m = 0;
    static List<Integer> power = null;
    static Map<Integer, String> map = null;
    public static void main(String[] args) throws IOException {
        init();
        int p, low, high, mid;
        boolean sameFlag = false;
        for (int i = 0; i < m; i++){
            p = Integer.parseInt(br.readLine());
            low = 0; high = power.size() - 1; sameFlag = false;
            if (p <= power.get(0)) {
                bw.write(map.get(power.get(0)) + "\n");
                continue;
            }
            while(low < high){
                mid = (low+high)/2;
                if (p < power.get(mid)){
                    high = mid - 1;
                    if (high < 0) high = 0;
                } else if (p > power.get(mid)){
                    low = mid + 1;
                    if (low > power.size() - 1) low = power.size() - 1;
                } else {
                    bw.write(map.get(power.get(mid)) + "\n");
                    sameFlag = true;
                    break;
                }
            }
            if (!sameFlag){
                if (p > power.get(low)) low++;
                bw.write(map.get(power.get(low)) + "\n");
            }
        }

        finish();
    }

    static void init() throws IOException {
        in = new StringTokenizer(br.readLine());
        n = Integer.parseInt(in.nextToken());
        m = Integer.parseInt(in.nextToken());
        map = new HashMap<>();
        power = new ArrayList<>();
        for(int i = 0; i < n; i++){
            in = new StringTokenizer(br.readLine());
            String title = in.nextToken();
            int p = Integer.parseInt(in.nextToken());
            if (!map.containsKey(p)){
                power.add(p);
                map.put(p, title);
            }
        }
    }
    static void finish() throws IOException {
        bw.flush();
        bw.close();
    }
}

//    static void finish() throws IOException {
//        bw.write(result + "\n");
//        bw.flush();
//        bw.close();
//    }

//    static void finish(int sum) throws IOException {
//        bw.write(sum + "\n");
//        bw.flush();
//        bw.close();
//    }
