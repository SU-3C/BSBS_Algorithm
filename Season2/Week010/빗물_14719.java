package programmers;

import java.io.*;
import java.util.*;

// 1. 스택에 넣는 경우 max보다 작은 경우
// 2. ( 현재 요소가 max와 같거나 || 크거나 ) || 마지막 요소일 경우
//     2-1. max와 요소 중 더 작은 값으로 스택에서 하나씩 pop하여 빼고 sum에 더해준다.
//     2-2. 마지막 요소가 아니면 둘 중에 더 큰 값을 max로 설정
// 3. 이 세계의 좌우 양쪽 끝이 벽으로 막혀있지 않고 뚫려 있을 경우
//     -> 즉 0으로 시작하거나 0으로 끝나는 경우 그 사이에는 빗물 계산을 안함.

class backjun {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer in = null;
    static int[] arr = null;
    static int n=0, m=0;
    public static void main(String[] args) throws IOException {
        init();
        int max = arr[0];
        int min = 0;
        int sum = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < max) s.push(arr[i]);
            else {
                min = (arr[i] < max)?arr[i]:max;
                while(!s.empty()){
                    sum += min - s.pop();
                }
                max = (arr[i]>max)?arr[i]:max;
            }
            if (i == arr.length - 1 && !s.empty() ) {
                min = s.pop();
                while(!s.empty()){
                    if (s.peek() <= min) sum += min - s.pop();
                    else {
                        min = s.pop();
                    }
                }
            }
        }
        finish(sum);
    }


    static void init() throws IOException{
        in = new StringTokenizer(br.readLine());
        n = Integer.parseInt(in.nextToken());
        m = Integer.parseInt(in.nextToken());
        arr = new int[m];
        in = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(in.nextToken());
        }
    }

    static void finish(int sum) throws IOException {
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
