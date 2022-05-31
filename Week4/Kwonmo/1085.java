package week4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class SquareEscape{
   public static int distance(int x,int y,int w,int h) {
      int minx = Math.min(x, w-x);   
      int miny = Math.min(y, h-y);   
      int dis=Math.min(minx, miny);
      return dis;
   }
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
      StringTokenizer st = new StringTokenizer(br.readLine());
        
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      System.out.println(distance(x,y,w,h));
   }
 //dis=Math.abs(x+y-(w+h))/Math.sqrt(x*x+y*y); 로 직선의방정식 구해서 점과 직선사이의 거리로 구할까
}
