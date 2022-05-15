package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ox 점수 문제
public class Main_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short N = Short.parseShort(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (byte i = 0; i < N; i++){
            String ox = br.readLine();
            short point = 0, count = 1;
            for(byte j = 0; j < ox.length(); j++){
                if(ox.charAt(j) == 'O'){
                    point += (count++);
                } else {
                    count = 1;
                }
            }
            sb.append(point + "\n");
        }
        System.out.print(sb);
    }
}

//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    short N = Short.parseShort(br.readLine());
//    String[] ox = new String[N];
//    short point = 0, count = 1;
//        for (byte i = 0; i < N; i++){
//        ox[i] = br.readLine();
//        for(byte j = 0; j < ox[i].length(); j++){
//        if(ox[i].charAt(j) == 'O'){
//        point += (count++);
//        } else {
//        count = 1;
//        }
//        }
//        ox[i] = Integer.toString(point);
//        point = 0; count = 1;
//        }
//        for (byte i = 0; i < N; i++){
//        System.out.println(ox[i]);
//        }