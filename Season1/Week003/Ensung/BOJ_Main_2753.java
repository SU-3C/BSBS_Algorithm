import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Main_2753 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(bf.readLine());
		// a가 4의 배수이거나 100배수가 아닐때
		if ((a % 4) == 0 && (a%100) != 0) {
			System.out.println("1");
			
			//4의배수거나 400의배수일때
		} else if ((a % 4) == 0 && (a % 400) == 0) {
			System.out.println("1");
			//나머지
		} else {
			System.out.println("0");
		}

	}

}