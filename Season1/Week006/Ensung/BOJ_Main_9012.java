import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_Main_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            boolean check = false;
            //0에서 감소했을경우 확인하려고 사용한 함수
            String s = bf.readLine();
            for (int j = 0; j < s.length(); j++) {//글자를 하나씩 읽는다
                if (s.charAt(j) == ('(')) {// 글자 하나씩 읽는데 거기에 (가 있을경우
                    stack.push('('); // 스택에 추가
                } else if (s.charAt(j) == (')')) {
                    if (!stack.empty()) { //비어있지 않으면 삭제
                        stack.pop();
                    } else { // 더 이상 추가된 스택이 없는데 삭제를하면 yes될수 없다 판단 후 체크하고 종료
                        check = true;
                        break;
                    }

                }

            }
            if (!stack.empty() || check) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                //만약 체크가 되어있거나 비어있지 않으면 no
                //비어있으면 yes처리
            }
        }
    }
}
