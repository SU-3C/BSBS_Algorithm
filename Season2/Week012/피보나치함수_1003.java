package programmers;




import java.io.*;
import java.util.*;

class backjun {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer in = null;
    static int t=0, n=0, oneCnt = 0, zeroCnt = 0;
    static int[] memArr = null;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        init();
        finish();
    }


    static void init() throws IOException{
        in = new StringTokenizer(br.readLine());
        t = Integer.parseInt(in.nextToken());
        for(int i = 0; i < t; i++){
            in = new StringTokenizer(br.readLine());
            n = Integer.parseInt(in.nextToken());
            memArr = new int[n+1];
            zeroCnt = 0;
            oneCnt = 0;
            fib(n);
            bw.write(zeroCnt + " " + oneCnt + "\n");
        }
    }
    static void finish() throws IOException {
        bw.flush();
        bw.close();
    }

    static int fib(int n) {
        if (n < 2) {
            if (n == 1) oneCnt++;
            else zeroCnt++;
            return memArr[n] = n;
        }
        if (memArr[n] > 0) {
            zeroCnt += map.get(n).get(0);
            oneCnt +=  map.get(n).get(1);
            return memArr[n];
        }
        memArr[n] = fib(n-1) + fib(n-2);
        if (!map.containsKey(n)) {
            List<Integer> list = new ArrayList<>(2);
            list.add(zeroCnt);
            list.add(oneCnt);
            map.put(n, list);
        }
        return memArr[n];
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
