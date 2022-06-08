import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_1100 {

	public static void main(String[] args) throws IOException {
		String s;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int count = 0;
	
		for (int i = 0; i < 8; i++) {
			s = bf.readLine();
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 == 0 && s.charAt(j) == 'F') {
					count++;
				} // (짝수,짝수)이고 F가 있을때 그값에 증가
					if (i % 2 == 1 && j % 2 == 1 && s.charAt(j) == 'F') {
						count++;
						//(홀수,홀수)이고 F가 있을때 그값에
					}
				}
			
			}
		System.out.println(count);	
		}
	}

