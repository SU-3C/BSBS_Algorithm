import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_10419 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			int d = Integer.parseInt(bf.readLine());
			int late = 0;
			for (late = 0;; late++) {
				if (d < late + late*late) {
					late = late - 1;
					break;
				}
				
			}
			System.out.println(late);
		}

	}

}
