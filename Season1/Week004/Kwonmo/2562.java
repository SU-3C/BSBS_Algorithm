package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class FindMax {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int[] arr = new int[9];//수를 배열에 담고
		
		for(int i = 0 ; i < 9 ; i++) { //반복문을 통해서 버퍼를 통하여 입력받는다. 이떄 입력값은 배열에 담긴다
			arr[i] = Integer.parseInt(br.readLine());
		}
 
		int max = 0;
		int index = 0;
		int count = 0;
		
		for(int value : arr) {//for-each문을 통해 배열의 인덱스를 비교한다.
			count++; //비교하기전에 count는 1증가 시켜야 나중에 반복이 끝나고 몇번째인지 확인 가능
			if(value > max) {
				max = value;
				index = count;
			}
		}
		System.out.println(max);
		System.out.println(index);
 
	}
}
