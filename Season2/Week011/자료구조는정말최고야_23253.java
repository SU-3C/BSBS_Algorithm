import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer in = null;
    static int n=0, m=0;
    static Map<Integer, Stack<Integer>> bookTopMapp = null;
    public static void main(String[] args) throws IOException {
        init();
        finish((checkBookTop())?"Yes":"No");
    }


    static void init() throws IOException{
        in = new StringTokenizer(br.readLine());
        n = Integer.parseInt(in.nextToken());
        m = Integer.parseInt(in.nextToken());
        bookTopMapp = new HashMap<>(m);
        int k = 0;
        Stack<Integer> s = null;
        for(int i =0; i < m; i++){
            in = new StringTokenizer(br.readLine());
            k = Integer.parseInt(in.nextToken());
            s = new Stack<>();
            in = new StringTokenizer(br.readLine());
            for(int j = 0; j < k-1;j++){
                s.push(Integer.parseInt(in.nextToken()));
            }
            bookTopMapp.put(Integer.parseInt(in.nextToken()), s);
        }
    }

    static boolean checkBookTop(){
        int seq = 0;
        while(true) {
            if (bookTopMapp.containsKey(seq+1)){
                seq++;
                Stack s = bookTopMapp.get(seq);
                if (!s.isEmpty()) {
                    int t = (int)s.pop();
                    bookTopMapp.put(t, s);
                }
            } else {
                break;
            }
        }
        if (seq == n)
            return true;
        return false;
    }
    static void finish(String result) throws IOException {
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}