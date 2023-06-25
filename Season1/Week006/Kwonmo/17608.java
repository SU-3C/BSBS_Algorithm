import java.util.Scanner;

public class Bak17608 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N]; 
		for(int i=0; i<arr.length; i++)
			arr[i] = sc.nextInt();  //배열 초기화
		
		int count = 1;		// 오른쪽에서 보이는 갯수
		int maxHeight = arr[arr.length-1];	// 가장 높은 막대기의 높이를 가장 앞에서 보이는 막대기로 설정
	
		for(int i=arr.length-2; i>=0; i--) {
			if(arr[i] > maxHeight) { //가장 높은 막대기보다 그 바로 뒤에 있는 막대기가 더 길면 cont++
				count ++;
				maxHeight = arr[i];
			}
		}
		
		System.out.println(count);
		sc.close();
	}

}
