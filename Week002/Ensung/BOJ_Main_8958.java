import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String string;
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			int count = 0; 
			int sum = 0;
			string = br.readLine();
			String[] array = string.split("");
			
			for (int j = 0; j < array.length; j++) {
				if (array[j].equals("O")) {
					count++;
					sum += count;
				} else {
					count = 0;
				}
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}
}