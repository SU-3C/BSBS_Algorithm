package week5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
// 난쟁이 낄끼빠빠
public class Main_3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Byte> list = new ArrayList<>();
        int sum = 0;
        for (byte i = 0; i < 9; i++){
            byte r = Byte.parseByte(br.readLine());
            list.add(r);
            sum += r;
        }
        // 모두 더한 수에서 100을 뺀 값을 이용해 난쟁이 두마리 구하기
        sum -= 100;
        for (byte i : list){
            // sum을 x + y 라고 쳤을 때
            // x는 리스트의 0번째 요소부터 반복
            // y는 sum - x 가 되겠죵
            byte x = i;
            byte y = (byte) (sum - x);
            // 만약 sum - x 값인 y 가 list에 존재할 경우
            // 즉 x + y가 sum 이 되는데 둘 다 list에 존재할 경우
            if (list.contains(y)){
                // 해당 요소 두개를 list에서 삭제 후 반복 종료
                list.remove((Object)x); list.remove((Object)y);
                break;
            }
        }
        for (byte i : list){
            bw.write(i+"\n");
        }
        bw.flush();
    }
}