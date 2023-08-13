package programmers;

import java.io.*;
import java.util.*;

class backjun {
    static LinkedList<LinkedList<Integer>> gear = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = null;
        for(int i = 0; i < 4; i++){
            gear.add(new LinkedList<>());
            in = br.readLine().split("");
            for(String s : in){
                gear.get(i).add(Integer.parseInt(s));
            }
        }
        int k = Integer.parseInt(br.readLine());
        int gIdx = 0, dir = 0, idx2 = 0, idx6 = 0;
        for(int i = 0; i < k; i++){
            in = br.readLine().split(" ");
            gIdx = Integer.parseInt(in[0]) - 1;
            dir = Integer.parseInt(in[1]);
            // 돌리기 전에 옆 톱니바퀴와 비교 하기 위해 저장
            idx2 = gear.get(gIdx).get(2); // 얘는 오른쪽 톱니바퀴의 6번째와 비교
            idx6 = gear.get(gIdx).get(6); // 얘는 왼쪽 톱니바퀴의 6번째와 비교
            lotation(gIdx, dir); // 돌려부러
            int tDir = dir;
            for (int j = gIdx - 1; j >= 0; j--){  // 현재 기어의 왼쪽 부분 반복
                tDir *= -1; // 내 바로 옆의 톱니를 돌릴 방향은 반대 방향
                if(gear.get(j).get(2) != idx6) { // 톱니끼리 다르면 돌리기
                    idx6 = gear.get(j).get(6); // 돌리기 전에 현재 톱니를 그 다음 톱니와 비교하기 위해 저장
                    lotation(j, tDir); // 다 돌려놔~
                } else {
                    break;
                }
            }
            tDir = dir;
            for (int j = gIdx + 1; j < 4; j++){ // 현재 기어의 오른쪽 부분 반복
                tDir *= -1; // 내 바로 옆의 톱니를 돌릴 방향은 반대 방향
                if(gear.get(j).get(6) != idx2) {
                    idx2 = gear.get(j).get(2);
                    lotation(j, tDir);
                } else {
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 4; i++){
            if (gear.get(i).get(0) == 1)
                sum += Math.pow(2, i); // 1, 2, 4, 8
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
    static void lotation(int gIdx, int dir){
        if (dir == 1){
            gear.get(gIdx).addFirst(gear.get(gIdx).removeLast());
        } else {
            gear.get(gIdx).addLast(gear.get(gIdx).removeFirst());
        }
    }
}


