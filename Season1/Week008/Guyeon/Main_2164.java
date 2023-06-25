package week8;

import java.io.*;
import java.util.LinkedList;
// 큐 카드문제
public class Main_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> q = new LinkedList<>();
        int n=Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++, q.add(i));
        while(true){
            if(q.size()==1) {
                bw.write(q.poll()+"");
                bw.flush();
                return;
            }
            q.poll();
            q.add(q.poll());
        }
    }
}
