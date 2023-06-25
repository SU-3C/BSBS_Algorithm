package week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Bak10799_stick {

	public static void main(String[] args) throws IOException {
		//"쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다" 라는 조건때문에 )를 만나기 전까지의 (의 갯수는 결국 조각수가 된다.
		// ()가 단일로 존재하면 레이저1 조각0으로 생각
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        Stack<Character> stack= new Stack<>();
        int result=0;
        for(int i=0;i<input.length();i++) {
        	if(input.charAt(i)=='(') {//열린괄호면 스택에 푸시
        		stack.push('(');
        	}
        	else if(input.charAt(i)==')') {
        		stack.pop(); // )의 쌍이였던 (를 pop
        		if(input.charAt(i-1)=='(') {// () 는 레이저, 레이저 전까지 쌓인 스택의 사이즈만큼 조각수가 형성된거라 더해줌
        			result+=stack.size();
        		}else result++; //그게 아니면 그냥 조각수 하나 추가
        	}
        }
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
	}
}
