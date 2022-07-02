package Algorithm07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String sentence = "";
		char compChar = ' ';
		boolean balance = true;
		Stack<Character> stack = new Stack<>();
		while (true) {
			sentence = br.readLine();
			if (sentence.charAt(0) == '.')
				break;
			loop:
			for(int i =0; i<sentence.length();i++) {
				compChar=sentence.charAt(i);
				switch(compChar) {
				case'(':stack.push(compChar);
					break;
				case'[':stack.push(compChar);
					break;
				case')':
					if(stack.empty()) {
						stack.push(compChar);break loop;
					}else if(stack.peek()=='('){
						stack.pop();
						break;
					}else {
						stack.push(compChar);break loop;
					}
				case']':
					if(stack.empty()) {
						stack.push(compChar);break loop;
					}else if(stack.peek()=='['){
						stack.pop();
						break;
					}else {
						stack.push(compChar);break loop;
					}
				}//end switch
			}//end for(loop)
			balance = stack.size()==0?true:false;
			if (balance)
				bw.write("yes\n");
			else
				bw.write("no\n");

			bw.flush();
			balance=true;
			stack.clear();
		} // end of while
		br.close();
		bw.close();
	}// end of main
}
