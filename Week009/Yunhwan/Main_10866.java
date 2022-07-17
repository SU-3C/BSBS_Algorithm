package Algorithm09;
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10866 {
	static Deque<java.lang.String> deque = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringTokenizer st;
		int testCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCount; i++) {
			st = new StringTokenizer(br.readLine());
			bw.append(command(st));
		}//end of for
		bw.flush();
		br.close();
		bw.close();
	}//end of main
	public static java.lang.StringBuilder command(StringTokenizer st) throws IOException {
		java.lang.StringBuilder value = new java.lang.StringBuilder("");
		switch (st.nextToken()) {
			case "push_front":
				deque.addFirst(st.nextToken());
				break;
			case "push_back":
				deque.addLast(st.nextToken());
				break;
			case "pop_front":
				value = new StringBuilder((deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n"));
				break;
			case "pop_back":
				value = new StringBuilder(deque.isEmpty() ? "-1\n" : deque.pollLast()+"\n");
				break;
			case "size":
				value = new StringBuilder(deque.size()+"\n");
				break;
			case "empty":
				value = new StringBuilder(deque.isEmpty()?"1\n":"0\n");
				break;
			case "front":
				value = new StringBuilder(deque.isEmpty() ? "-1\n" : deque.peekFirst()+"\n");
				break;
			case "back":
				value = new StringBuilder(deque.isEmpty() ? "-1\n" : deque.peekLast()+"\n");
				break;
		}
		return value;
	}//end of command()

}//end of class
