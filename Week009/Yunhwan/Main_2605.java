package Algorithm09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2605 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		short student = Short.parseShort(br.readLine());
		StringBuilder result = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> a1 = new ArrayList<>();
		int orderNum;
		for (int i = 1; i <= student; i++) {
			orderNum = Integer.parseInt(st.nextToken());
			if (orderNum == 0) {//뽑은 수가 0일때 (자리변동이 없을 때)
				a1.add(i);
			} else {//i번째 뽑는 학생에서 뽑은 수를 빼준 자리에 삽입
				a1.add(i-orderNum-1, i);
			}
		}//end of for
		for(int i=0; i<a1.size();i++){//ArrayList의 요소 출력을 위한 반복
			result.append(a1.get(i)+" ");
		}//end of for
		System.out.println(result);
	}
}
