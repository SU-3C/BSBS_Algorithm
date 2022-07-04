package week7;

import java.io.*;
import java.util.Stack;

// 후위표기식에 값 넣어서 계산하기
public class Main_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Double> s = new Stack<>();
        int n=Integer.parseInt(br.readLine());
        double[] arr=new double[n];
        String in=br.readLine();
        for(int i=0;i<n;i++){
            arr[i]=Float.parseFloat(br.readLine());
        }
        double a1, a2;
        for (int i=0;i<in.length();i++){
            char c=in.charAt(i);
            if (c>='A' && c<='Z'){
                s.push(arr[c-'A']);
            } else {
                a1=s.pop(); a2=s.pop();
                if (c=='+') {
                    s.push(a2+a1);
                } else if (c=='-') {
                    s.push(a2-a1);
                } else if (c=='*') {
                    s.push(a2*a1);
                } else if (c=='/') {
                    s.push(a2/a1);
                }
            }
        }
        bw.write(String.format("%.2f"+"", s.pop()));
        bw.flush();
    }
}