package Algorithm09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9372 {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		String[] testContent;
		for(int i =0; i<testNum; i++){
			testContent = br.readLine().split(" ");
			int airplanecount = Integer.parseInt(testContent[1]);
			for (int j =0; j<airplanecount;j++){
				String[][] airplane = new String[airplanecount][];
				airplane[j] = br.readLine().split(" ");
				
			}//end of for j


		}//end of for i

	}
}
