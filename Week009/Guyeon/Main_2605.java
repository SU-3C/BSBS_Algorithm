package week9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_2605 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        String[] in=br.readLine().split(" ");
        int m;
        List<Integer> l=new ArrayList<>();
        for(int i=0; i<n; i++){
            m=Integer.parseInt(in[i]);
            l.add(l.size()-m, (i+1));
        }
        for(int i:l){
            bw.write(i+" ");
        }
        bw.flush();
    }
}