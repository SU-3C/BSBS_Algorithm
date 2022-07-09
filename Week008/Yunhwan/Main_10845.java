package Algorithm08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> subqueue = new LinkedList<>();

		int commandLine = Integer.parseInt(br.readLine());
		String cmd;
		for (int i = 0; i < commandLine; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch (cmd) {
				case "push":
					queue.add(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if (queue.size() == 0) System.out.println(-1);
					else System.out.println(queue.poll());
					break;
				case "size":
					System.out.println(queue.size());
					break;
				case "empty":
					if (queue.isEmpty()) System.out.println(1);
					else System.out.println(0);
					break;
				case "front":
					if (queue.isEmpty()) System.out.println(-1);
					else System.out.println(queue.peek());
					break;
				case "back":
					if (queue.isEmpty()) System.out.println(-1);
					else {
						while(queue.size()>1){
							subqueue.add(queue.poll());
						}
						System.out.println(queue.peek());
						subqueue.add(queue.poll());
						queue.addAll(subqueue);
						subqueue.clear();
					}//end of else - case "break"
					break;
			}//end of switch
		}//end of for
		br.close();
	}//end of main
}
