package Algorithm08;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> queue =new LinkedList<>();

		StringBuilder sb = new StringBuilder();
		int commandLine = Integer.parseInt(br.readLine());
		String cmd, val;
		for (int i = 0; i < commandLine; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch (cmd) {
				case "push":
					queue.add(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					val = queue.size() == 0?"-1\n":queue.poll()+"\n";
					bw.append(val);
					break;
				case "size":
					bw.append(queue.size()+"\n");
					break;
				case "empty":
					val = queue.isEmpty()?"1\n":"0\n";
					bw.append(val);
					break;
				case "front":
					val = queue.isEmpty()?"-1\n":queue.peek()+"\n";
					bw.append(val);
					break;
				case "back":
					val = queue.isEmpty()?"-1\n":queue.getLast()+"\n";
					bw.append(val);
					break;
			}//end of switch

		}//end of for
		bw.flush();
		br.close();
		bw.close();
	}//end of main
}
