package week7;

import java.io.*;
import java.util.Stack;

// 스택 수열2 오름차순 삽입으로 주어진 수열 만들기
public class Main_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        int n=Integer.parseInt(br.readLine()), max=1;
        int[] a = new int[n];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i<n;i++){
            if(max<=a[i]){
                for(int j=max;j<a[i];j++){
                    s.push(j);
                    sb.append("+\n");
                }
                sb.append("+\n-\n"); // 4까지 push하고 4는 pop해야하는데 4를 push pop하는과정은 생략하고 값 출력만
                max=a[i]+1;
            } else {
                if (a[i]==s.pop()){
                    sb.append("-\n");
                } else {
                    bw.write("NO"+"");
                    bw.flush();
                    return;
                }
            }
        }
        bw.write(sb+"");
        bw.flush();
    }
}