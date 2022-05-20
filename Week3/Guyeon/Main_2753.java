import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2753 윤년 문제
public class Main_2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short y = Short.parseShort(br.readLine());
        System.out.print(((y%4 == 0 && y%100 != 0) || (y%400 == 0))? 1 : 0);
    }
}