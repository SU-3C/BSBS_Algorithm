import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_20001 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        //
        if (s.equals("고무오리 디버깅 시작")) {
            int count = 0;
            //갯수를 담을값
            s = bf.readLine();
            while (!s.equals("고무오리 디버깅 끝")) {
                if (s.equals("문제")) {
                    count++;
                    //만약 문제를 입력하면 1이 추가가된다.
                }
                if (s.equals("고무오리")) {
                    if (count > 0) {
                        count--;

                    } else if (count == 0) {
                        count = count + 2;
                    }
                    //고무오리를 입력하면 추가된 문제를 삭제한다.
                    //만약 삭제할 문제가 없다면 벌칙으로 2문제를 받아야한다.
                }
                s = bf.readLine();
            }
            if (count > 0) {
                System.out.println("힝구");
            } else {
                System.out.println("고무오리야 사랑해");
            }
            //만약 0보다 크면 즉, 문제가 있다면 힝구
            //아니라면 고무오리야 사랑해이다.

        }

    }
}
