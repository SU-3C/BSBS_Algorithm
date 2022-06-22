package Algorithm04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int distanceX = (w-x)>x ? x:(w-x);
		int distanceY = (h-y)>y ? y:(h-y);
		
		if(distanceX<distanceY) {
			System.out.println(distanceX);
		}else {
			System.out.println(distanceY);
		}
		
	}
}
