import java.io.*;
import java.util.StringTokenizer;

public class Main_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int max = a[0], min = a[0];
        for (int i = 1; i < N; i++){
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
        System.out.print(min + " " + max);
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        bw.write(min + " " + max);
//        bw.flush();
//        bw.close();
    }
}
//        Arrays.sort(a);
//        bw.write(a[0] + " " + a[N-1]);

//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = br.read();
//    int[] a = new int[N];
//        for (byte i = 0; i < N; i++){
//        a[i] = br.read();
//        }