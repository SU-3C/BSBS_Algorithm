package Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_Main_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        String cmd = bf.readLine();
        Stack<Double> stack = new Stack<>();
        Double[] AValue = new Double[T];
        for (int i = 0; i < T; i++)
            AValue[i] = Double.parseDouble(bf.readLine());

        for (int i = 0; i < cmd.length(); i++) {
            Character c = cmd.charAt(i);
            if ('A' <= c && c <= 'Z')
                stack.push(AValue[c - 'A']); //  예를 들어서 A = 1 , B = 2 , C= 3
            else {
                Double[] number = new Double[2];
                number[0] = stack.pop();
                number[1] = stack.pop();
                //빠져나온 값을 배열에 추가한다.
                switch (c.charValue()) {
                    case '+':
                        stack.push(number[1] + number[0]);
                        break;
                    case '-':
                        stack.push(number[1] - number[0]);
                        break;
                    case '*':
                        stack.push(number[1] * number[0]);
                        break;
                    case '/':
                        stack.push(number[1] / number[0]);
                        break;
                }
            }
        }
        System.out.printf("%.2f",stack.peek());
    }
}
