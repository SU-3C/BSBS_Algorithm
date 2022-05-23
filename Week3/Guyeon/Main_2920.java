import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2920번 음계문제
public class Main_2920 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        byte[] a = new byte[8];
        for (byte i = 0; i < 8; i++){
            a[i] = Byte.parseByte(st.nextToken());
        }
        System.out.print(f(a));
    }
    public static String f(byte[] a){
        byte v = 0, count = 0;
        for(byte i = 1;i < a.length; i++){
            // 음계 사이사이 차를 가지고 판별
            v = (byte) (a[i - 1] - a[i]);
            if (v == 1) ++count; // 내림차순이면 1만 나옴
            else if (v == -1) --count; // 오름차순이면 -1만 나옴
            else break;
        }
        if (count == 7)
            return "descending";
        else if (count == -7)
            return "ascending";
        else
            return "mixed";
    }
}
