import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2839 번 사탕 배달
public class Main_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short S = Short.parseShort(br.readLine());
        System.out.print(f(S));
    }
    public static short f(short S){
        short c = 0;
        // 4와 7은 -1
        if (S == 4 || S == 7) {
            return -1;
        }
        // 0이상 12 9 6 3 을 제외한 모든 경우에 S에 -1와 count를 ++해줌
        while(S > 0 && !(S <= 12 && S % 3 == 0) ){
            S -= 5;
            c++;
        }
        // 12 9 6 3 이 나온 경우에 while을 빠져나오고 3으로 나눈 몫을 count에 더해줌
        c += S/3;
        return c;
    }
}