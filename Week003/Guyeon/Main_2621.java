package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 2621번 카드게임 문제
public class Main_2621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Byte> n = new ArrayList<>();
        byte[] nc = new byte[10];
        byte f = 1, sum = 0, m = 10, M = 0, m3= 0, m21 = 0, m22 = 0;
        short r = 0;
        String c = "";
        for (byte i = 0; i < 5; i++){
            String[] sa = br.readLine().split(" ");
            if (i > 0 && !c.equals(sa[0])) f = 0;
            c = sa[0];
            byte v = Byte.parseByte(sa[1]);
            n.add(v);
            nc[v]++;
        }
        for (Byte b : n){
            sum += b; // 평균수 구하기 위함
            m = (m < b)? m:b; // 숫자가 이어지는지 판단 할 때 쓰임
            M = (M > b)? M:b; // 최대값 구하기 위함
        }
        if (M - m == 4 && n.contains((byte)(sum/5))){ // 최대값 - 최소값이 4 이며 평균수가 존재할 경우 모든 숫자가 이어지는 경우
            // 이어지면서 색이 같으면 참 색이 같지 않으면 거짓
            r = (short) ((f == 1)?(M + 900):(M+500));
            System.out.print(r);
        } else { // 숫자가 이어지지 않는 경우
            // 숫자가 이어지지 않는데 색이 모두 같은 경우
            if (f == 1) {
                System.out.print(M + 600);
            }
            else { // 숫자가 이어지지 않고 색이 다른 경우 -> 숫자의 개수 조합으로 점수
                for (byte i = 1; i < 10; i++) {
                    if (nc[i] == 4) { // 똑같은 숫자 4개 등장
                        System.out.print(i + 800);
                        return;
                    } else if (nc[i] == 3){ // 똑같은 숫자 3개 등장
                        m3 = i;
                        if (m21 > 0) { // 이전에 똑같은 숫자 2개가 발견된 경우
                            System.out.print(700 + m3*10 + m21); return;
                        }
                    } else if (nc[i] == 2){ // 똑같은 숫자 2개 등장
                        if (m3 > 0) { // 이전에 똑같은 숫자 3개가 발견된 경우
                            m22 = i;
                            System.out.print(700 + m3*10 + m22); return;
                        } else {
                            if (m21 > 0) { // 이전에 똑같은 숫자 2개가 발견된 경우
                                m22 = i;
                                System.out.print(300 + m22*10 + m21); return;
                            } else { // 이전에 똑같은 숫자가 발견되지 않은 경우
                                m21 = i;
                            }
                        }
                    }
                }
                if (m22 == 0){ // 똑같은 숫자 2개가 2번째로 등장하지 않은 경우
                    if (m3 > 0) System.out.print(400 + m3); // 똑같은 숫자 3개만 있는 경우
                    else if (m21 > 0)System.out.print(200 + m21); // 똑같은 숫자 2개만 있는 경우
                    else System.out.print(100 + M); // 똑같은 숫자가 아예 없는 경우
                    return;
                }
            }
        }
    }
}