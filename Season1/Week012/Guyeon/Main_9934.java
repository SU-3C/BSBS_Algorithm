package week12;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.*;

public class Main_9934 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int[] t = new int[in.length];
        for (int i = 0; i < t.length; i++) {
            t[i] = Integer.parseInt(in[i]);
        }
        f(t);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < pow(2, i); j++) {
                bw.write(l.poll() + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static Queue<Integer> l = new LinkedList<>();
    static Queue<int[]> q = new LinkedList<>();

    static void f(int[] t) {
        l.add(t[t.length / 2]);
        if (t.length > 1) {
            int[] temp1 = new int[t.length / 2];
            int[] temp2 = new int[t.length / 2];
            for (int i = 0; i < t.length; i++) {
                if (i < t.length / 2) {
                    temp1[i] = t[i];
                } else if (i > t.length / 2) {
                    temp2[i - t.length / 2 - 1] = t[i];
                }
            }
            q.add(temp1); q.add(temp2);
        }
        while(!q.isEmpty())
            f(q.poll());
    }
}