package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 손익분기점 문제 1712번
public class Main_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (byte i = 0; i < 3; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        int count;
        if (data[1] >= data[2]) count = -1;
        else {
            count = data[0] / (data[2] - data[1]) + 1;
        }
        System.out.print(count);
    }
}
