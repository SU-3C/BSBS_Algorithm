import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(bf.readLine());

        for(int i=0; i<T; i++){
            String[] s = bf.readLine().split(" ");
            //띄워쓰기 나눠서 값을 읽는다.
            System.out.print("Case #"+(i+1)+": ");
            //케이스를 추가하는 출력값
            for(int j =s.length-1; j>=0; j--){
                System.out.print(s[j]+" ");
                //맨뒤에서 읽는다 하나씩
            }
            System.out.print("\n");
        }

    }
}
