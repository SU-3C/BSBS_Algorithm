import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer in = null;
    static int n=0;
    public static void main(String[] args) throws IOException {
        init();
        bw.flush();
        bw.close();
    }


    static void init() throws IOException{
        in = new StringTokenizer(br.readLine());
        n = Integer.parseInt(in.nextToken());
        int a,b,c;
        for(int i = 0; i < n; i++){
            in = new StringTokenizer(br.readLine());
            a = Integer.parseInt(in.nextToken());
            b = Integer.parseInt(in.nextToken());
            c = Integer.parseInt(in.nextToken());
            if (a > 0 && c > 0 && a == c) {
                bw.write("Yes\n");
                continue;
            }
            else if (c > a) {
                bw.write("No\n");
                continue;
            }
            else if ((a-c)%2 == 1) {
                bw.write("No\n");
                continue;
            }
            else if (b%2 == 1 && a == 0){
                bw.write("No\n");
                continue;
            }
            else {
                bw.write("Yes\n");
            }
        }
    }
}