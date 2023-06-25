package Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_Main_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int count = 0;
        for (int i = 0; i < T; i++) {
            String s = bf.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if(!stack.isEmpty() && stack.peek()==s.charAt(j)) {
                    stack.pop();
                    //만약 같은숫자면 팝해서 밖으로 나간다.
                } else{
                    stack.push(s.charAt(j));
                    //그렇지 않다면 계속 푸쉬해서 쌓는다.
                }
            }
            if(stack.isEmpty()){
                count++;
                //만약에 비어있다. 짝이 맞아서 사라졌다. 그래서 카운트 올린다.
            }
            System.out.println(count);
        }
    }
}
