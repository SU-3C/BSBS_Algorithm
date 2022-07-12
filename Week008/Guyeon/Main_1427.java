package week8;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in=br.readLine();
        Integer[] arr=new Integer[in.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]=in.charAt(i)-'0';
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        for(int i:arr){
            bw.write(i+"");
        }
        bw.flush();
    }
}