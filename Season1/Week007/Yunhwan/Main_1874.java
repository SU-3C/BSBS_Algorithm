package Algorithm07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder("");
		Stack<Integer> stack = new Stack<>();
		int seqSize = Integer.parseInt(br.readLine());
		int[] seq = new int[seqSize];
		int now = 0;
		for (int i = 0; i < seqSize; i++) {//수열을 입력받는 반복문
			seq[i] = Integer.parseInt(br.readLine());
		}//end of for
		int count =1;//자동 추가된는 값들
		int index =0;
		int min=0;
		while(true){//조건 검사를 하는 반복문
			if(index==seqSize)break;//전부 검색 완료시 빠져나옴

			if(seq[index]==count){//목표수열값과 현재 넣어줄 값이 같으면
				result.append("+\n-\n");
				index++;
				count++;
			}else if(seq[index]>count){//목표 수열값이 현재 넣어줄 값보다 크면
				while(seq[index]>count){//목표수열값과 같을 때까지 push
					stack.push(count);
					result.append("+\n");
					count++;
				}//end of elseif-while
			}else{//목표값과 현재 넣어줄 값이 같지 않고
				// 현재 넣어줄 값이 목표값보다 클때
				if(stack.empty()){//목표 3 넣어줄값 5인데 스택이 비었으면 NO
									//seq = 3 count = 5, stack = []
					System.out.println("NO");
					System.exit(0);
				}else {//스택에 값이 있으면
					while(true){
						if(stack.empty()){//찾으면 빠져나오는데
							//스택이 빌때까지 뺏는 데 없으니까
							System.out.println("NO");
							System.exit(0);
						}
						if(stack.pop()==seq[index]) {//스택값이 목표값하고 같으면
							result.append("-\n"); //스택에서 값 뽑는 반복 종료
							index++;//찾았으니까 index증가
							break;//else-while문을 빠져나감
						}
						result.append("-\n");
					}//end of else-while
				}//end of inner else

			}//end of else

		}//end of while
		System.out.print(result);
	}//end of main
}
