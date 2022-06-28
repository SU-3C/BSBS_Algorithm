package Algorithm06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_20001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> Pstack = new Stack<>();
		String command = br.readLine();
		String problem = "문제";
		if (command.equals("고무오리 디버깅 시작")) {
			loop01:
			while (true) {
				switch (br.readLine()) {
				case "고무오리":
					if (Pstack.empty()) {//문제가 없는데 고무오리입력시 2개 추가
						Pstack.push(problem);
						Pstack.push(problem);
					} else {//문제가 있으면 빼줌
						Pstack.pop();
					}
					break;
				case "문제":
					Pstack.push(problem);
					break;
				case "고무오리 디버깅 끝":break loop01;//반복문을 빠져나가 입력종료
				}// end switch
			}
			if(Pstack.empty()) {
				System.out.println("고무오리야 사랑해");
			}else {
				System.out.println("힝구");
			}
		}
	}
}
