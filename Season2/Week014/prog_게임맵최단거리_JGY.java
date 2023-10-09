/*
프로그래머스 게임 맵 최단거리 : https://school.programmers.co.kr/learn/courses/30/lessons/1844

1. BFS 적용 1, 1 push, queue is not empty이면 반복
2. 상하좌우 중 0이면 pass
    2-1. 1이면 -> 다음 지점의 거리 = 현재 지점의 거리 + 1
    2-2. 거리가 -1이면 거리 설정 후 push
    2-3. 거리가 -1이 아니고 현재 거리가 더 작으면 작은 거리로 설정 후 push
3. pop 후 visit
4. visit 시 해당 지점에 거리 저장
5. 5, 5 도착 시 거리 출력 후 종료
6. 모두 순회 시 5, 5의 거리 출력 -> 도달 했다면 최단 거리, 못했다면 기본값인 -1이 출력 될 것

 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int answer = 1;
        Queue<Node> q1 = new LinkedList();
        Queue<Node> q2 = new LinkedList();
        int n = maps.length;
        int m = maps[0].length;
        int[][] adjust = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int r, c;

        q1.add(new Node(0, 0));
        while(!q1.isEmpty() || !q2.isEmpty()){
            answer++;
            while(!q1.isEmpty()){
                Node node = q1.poll();
                for(int[] ad : adjust) {
                    r = node.r + ad[0];
                    c = node.c + ad[1];
                    if (r == n-1 && c == m-1) return answer;
                    if (r > -1 && r < n && c > -1 && c < m && !(r==0 && c==0) && maps[r][c] == 1) {
                        maps[r][c] = answer;
                        q2.add(new Node(r, c));
                    }
                }
            }
            q1.addAll(q2);
            q2.clear();
        }
        return -1;
    }


    class Node {
        int r, c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}


public class Programmers {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(sol.solution(maps));
    }
}
