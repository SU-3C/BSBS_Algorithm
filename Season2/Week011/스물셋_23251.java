import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer in = null;
    static int n=0;
    public static void main(String[] args) throws IOException {
        init();
        int k = 0;
        int sum = 0;
        for(int i = 0; i < n; i ++){
            in = new StringTokenizer(br.readLine());
            k = Integer.parseInt(in.nextToken());
            for(int j=0; j<k; j++){
                sum+=23;
            }
            bw.write(sum + "\n");
            sum = 0;
        }
        bw.flush();
        bw.close();
    }


    static void init() throws IOException{
        in = new StringTokenizer(br.readLine());
        n = Integer.parseInt(in.nextToken());

    }
}