import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Main_1085 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int xmin = Math.min(x, w-x);
		int ymin = Math.min(y, h-y);
		
		System.out.println(Math.min(xmin, ymin));
	}

}
// 내가 생각했을때 문제를 어떤식으로 풀었냐면 x,y 값이 작으면 최소 경로라 생각했고 
// 전체의 값에 나머지 x,y의 최솟값을 비교하려고 했다. 
// 그래서 일단 x와 전체x-x,y와 전체-y 값의 최솟값구했고 그다음으로 최소된 x,y값에 최솟값을 구했다.
