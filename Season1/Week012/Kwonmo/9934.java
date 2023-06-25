import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] node = new int[(int)Math.pow(2, N)-1];
		ArrayList<LinkedList<Integer>> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new LinkedList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < node.length; i++) {
			node[i]=Integer.parseInt(st.nextToken());
		}
		
		cityRoute(list, node, 0, node.length, 0);
		
		for(int i=0; i<N; i++) {
			for(Integer e : list.get(i)) {
				System.out.print(e+" ");
			}
            System.out.println();
		}
	}
	
	static void cityRoute(ArrayList<LinkedList<Integer>> list, int[] node, 
			int first, int last, int depth) {
		//중위순회를 위한 함수 작성
		if(first==last)return;
		int mid = (first+last)/2; //중위순회에서 mid는 양쪽 자신노드/2
		//ex) 164 3 527
		list.get(depth).add(node[mid]); //깊이에 따른 부모노드 저장
		
		cityRoute(list, node, first, mid, depth+1);//left
		cityRoute(list, node, mid+1, last, depth+1);//right
	}
}
