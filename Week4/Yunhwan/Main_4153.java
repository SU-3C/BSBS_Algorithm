package Algorithm04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = new int[3];
		String result = "";

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[0] = Integer.parseInt(st.nextToken());
			input[1] = Integer.parseInt(st.nextToken());
			input[2] = Integer.parseInt(st.nextToken());
			if(0==input[0]&&0==input[1]&&0==input[2]) {
				break;
			}
			input[0] = pow(input[0]);
			input[1] = pow(input[1]);
			input[2] = pow(input[2]);
			if(   input[1]+input[2]==input[0]
				||input[0]+input[2]==input[1]
				||input[0]+input[1]==input[2])
			{
				result+="right\n";
			}else {
				result+="wrong\n";
			}
		}
		System.out.println(result);
	}

	public static int pow(int x) {
		return x * x;
	}
}
