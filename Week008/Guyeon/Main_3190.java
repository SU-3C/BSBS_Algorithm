package week8;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main_3190 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Point> q = new LinkedList<>();
        int N=Integer.parseInt(br.readLine()); // 맵 크기

        int K=Integer.parseInt(br.readLine()); // 사과 개수
        List<Point> kList = new ArrayList<>(); // 사과 위치
        Point kArr; // 사과 위치 받기 위한 배열
        String[] in;
        for(int i=0;i<K;i++){
            in=br.readLine().split(" "); // 사과 위치 입력
            kArr=new Point(Integer.parseInt(in[1]),Integer.parseInt(in[0]));
            kList.add(kArr); // 사과 위치 저장
        }
        int L=Integer.parseInt(br.readLine()); // 뱀 방향 변환 정보 개수
        List<String[]> lList = new ArrayList<>(); // 방향 변환 정보
        String[] lArr; // 방향 정보 받기 위한 배열
        for(int i=0;i<L;i++){
            in=br.readLine().split(" "); // 방향 변환 정보 입력
            lArr=new String[2];
            lArr[0]=in[0];
            lArr[1]=in[1];
            lList.add(lArr); // 변환 정보 저장
        }
        int timer=0;
        //char[] direc={0:'r', 1:'d', 2:'l', 3:'u'};
        int direcIndex=0, x=1, y=1;
        Point p=new Point(x,y);
        q.add(p);
        while(true){
            timer++;

            if(direcIndex==0)
                x++;
            else if(direcIndex==1)
                y++;
            else if(direcIndex==2)
                x--;
            else
                y--;
            p=new Point(x,y);
            if (N < p.getX() || p.getX() < 1 || N < p.getY() || p.getY() < 1){
                bw.write(timer+"");
                bw.flush();
                return;
            }
            for(int i=q.size()-1;i>=0;i--){
                if(q.get(i).isSamePoint(p)){
                    bw.write(timer+"");
                    bw.flush();
                    return;
                }
            }
//            for(Point point:q){
//                if(point.isSamePoint(p)) {
//                    bw.write(timer+"");
//                    bw.flush();
//                    return;
//                }
//            }
            q.add(p);

            if (!lList.isEmpty()){
                if(timer == Integer.parseInt(lList.get(0)[0])){
                    if (lList.get(0)[1].equals("L"))
                        direcIndex = (direcIndex-1 < 0)?3:direcIndex-1;
                    else
                        direcIndex = (direcIndex+1 > 3)?0:direcIndex+1;
                    lList.remove(0);
                }
            }

            if (!kList.isEmpty()){
                int j=0, size=kList.size();
                for(Point k:kList){
                    if(p.getX()==k.getX() && p.getY()==k.getY()){
                        kList.remove(k);
                        break;
                    }
                    if(j==size-1){
                        q.poll();
                    }
                    j++;
                }
            } else {
                q.poll();
            }
        }
    }
}
class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    boolean isSamePoint(Point p){
        if (this.x == p.x && this.y == p.y)
            return true;
        return false;
    }
}