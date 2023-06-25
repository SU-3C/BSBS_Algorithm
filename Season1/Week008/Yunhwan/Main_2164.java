package Algorithm08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_2164 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> queue = new LinkedList<>();
		int inputCard = Integer.parseInt(br.readLine());
		for (int i =1; i<=inputCard;i++){
			queue.add(i);
		}//end of for
		while(queue.size()>1){
			queue.poll();
			queue.add(queue.poll());
		}//end of while
		System.out.println(queue.poll());
	}//end of main
}
