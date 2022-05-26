package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//최댓값과 인덱스 출력
public class Main_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        byte max=0, mi=0;
        for(byte i=0; i<9; i++){
            byte t = Byte.parseByte(br.readLine());
            if (t>max){
                max=t;mi=i;
            }
        }
        System.out.print(max+"\n"+(mi+1));
    }
}