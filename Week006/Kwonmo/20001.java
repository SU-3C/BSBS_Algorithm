package week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bak20001 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Boolean> stack = new Stack<Boolean>();
        while (true) {
            String str = br.readLine();
            if (str.equals("고무오리")) {
                if (stack.size() == 0) { //고무오리를 입력했는데 사이즈가 0이면 push2번
                    stack.push(true);
                    stack.push(true);
                } else {
                    stack.pop();//그렇지 않으면 pop
                }
            } else if (str.equals("문제")) {
                stack.push(true);
            } else if (str.equals("고무오리 디버깅 끝")) {
                break;
            }
        }
        
        System.out.println(stack.isEmpty() ? "고무오리야 사랑해" : "힝구");
    }
}
