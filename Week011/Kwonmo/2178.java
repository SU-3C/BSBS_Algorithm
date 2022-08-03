import java.io.*;
import java.util.*;

public class Main_2178 {
  static int n, m;
  static int[] dx = {0, 1, 0, -1}; //상우하좌
  static int[] dy = {1, 0, -1, 0};
  static int[][] maze; //미로
  static boolean[][] checked;
  
  public static void main(String[] args) throws IOException {
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  m = sc.nextInt();
  maze = new int[n][m];
  checked = new boolean[n][m];
  
  for(int i = 0; i < n; i++) {
    String temp = sc.next(); //붙어서 입력되기 때문에 다음 공백까지 받아오는 .next() 사용
    for(int j = 0; j < m; j++) {
      maze[i][j] = (int)temp.charAt(j) - 48; //아스키코드값 변환
    }
  }
  bfs();
  System.out.print(maze[n - 1][m - 1]); //(N, M) 출력. 좌표값이기 때문에 -1
  }
  
  public static void bfs() {
    Queue<Integer> queue_x = new LinkedList<Integer>(); //x값에 대한 Queue
    Queue<Integer> queue_y = new LinkedList<Integer>(); //y값에 대한 Queue
    
    queue_x.offer(0); //저장
    queue_y.offer(0);
    
    checked[0][0] = true;
    
    while(!queue_x.isEmpty()) {
      int x = queue_x.poll();
      int y = queue_y.poll();
      
      //상하좌우 확인
      for(int k = 0; k < 4;k++) {
        int temp_x = x + dx[k];
        int temp_y = y + dy[k];
        
        //유효한 범위인지 확인
        if(temp_x >= 0 && temp_y >= 0 && temp_x < n && temp_y < m) {
          if(maze[temp_x][temp_y] == 1 && checked[temp_x][temp_y] == false) {
            queue_x.offer(temp_x);
            queue_y.offer(temp_y);
            
            checked[temp_x][temp_y] = true;
            
            maze[temp_x][temp_y] = maze[x][y] + 1; //이동횟수
          }
        }
      }
    }
  }
} 
