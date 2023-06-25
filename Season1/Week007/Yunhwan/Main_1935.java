package Algorithm07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main_1935 {
	public static void main(String[] args) throws IOException {
		Stack<Object> stack = new Stack<>();
		HashMap<Character, Double> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int varCount = Integer.parseInt(br.readLine());// 첫 줄
		String postfixExpression = br.readLine();// 두번째 줄 후위 표기식
		for(int i=0; i<varCount; i++) {//해당 문자에 해당하는 숫자값 넣기
			//65 ~ 90 = A ~ Z 아스키코드 값
			char c = (char)(65+i);//A부터 시작하니까
			map.put(c, Double.parseDouble(br.readLine()));// ex A - 1
		}//end of for

		for(int i=0; i<postfixExpression.length();i++) {//스택에 값을 해당하는 피연산자 값을 넣어줌
			Character key = new Character(postfixExpression.charAt(i));
			if(map.get(key)!=null) {//피연산자라면
				stack.push(map.get(key));//스택에 double형 피연산자값을 객체를 넣어줌
			}else {//연산자면 문자객체를 넣어줌
				double v2 = (Double)stack.pop();
				double v1 = (Double)stack.pop();
				stack.push(calc(key.charValue(),v1,v2));
			}
		}//end of for
		System.out.printf("%.2f",(Double)stack.pop());
	}//end of main
	
	
	public static Double calc(char c, double var1, double var2) {
		Double result= new Double(0.0);
		switch(c) {//수식 계산
		case'+': result = new Double(var1 + var2);
			break;
		case'-': result = new Double(var1 - var2);
			break;
		case'*': result = new Double(var1 * var2);
			break;
		case'/': result = new Double(var1 / var2);
			break;
		}//end of switch
		return result;
	}
}
