import java.io.IOException;
import java.util.Scanner;

public class BOJ_Main_3040 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int[] num = new int[9];
		int sum = 0;
		int index1 = 0;
		int index2 = 0;

		for (int i = 0; i < 9; i++) {
			num[i] = sc.nextInt();
			sum +=num[i];
		// 테스트 케이스를 입력하고 , 1~9의 입력 값을 더한다.
		}

		for (int j = 0; j < num.length; j++) {
			// 1번째로 배열반복
			for (int k = 0; k < num.length; k++) {
			//2번째로 배열반복
				if (j!=k && (sum - num[j] - num[k] == 100)) {
					//전체중에서-j-k를빼면100일때와 문자가 중복되면 안되니까 !=값을 쓴다. 
					num[j]=0;
					num[k]=0;
					break;
					//그값을 0 즉 삭제시켜준다.
				}
			}
		}
		
		for(int i=0;i<num.length;i++)
			if(num[i]>0)
				System.out.println(num[i]);
		// 0보다크니 0을 설정한 값은 나오지않고, 지워진 텍스트값을 출력한다
	}

}