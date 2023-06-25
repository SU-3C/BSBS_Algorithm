package Algorithm10;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main_24444 {
	static int[] NodeHistory;
	static int nodeCounter=0;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] NodeLineTarget = br.readLine().split(" ");
		int TotalNode = Integer.parseInt(NodeLineTarget[0]);
		int Line = Integer.parseInt(NodeLineTarget[1]);
		int Target = Integer.parseInt(NodeLineTarget[2]);

		NodeHistory = new int[TotalNode];
		Node[] nodeArr = new Node[TotalNode];

		//노드 초기화
		for (int i = 0; i < TotalNode; i++) {
			nodeArr[i] = new Node(i + 1);
		}//end of for i TotalNode

		//노드 연결 처리
		String[] request;
		int A, B;
		for (int i = 0; i < Line; i++) {
			request = br.readLine().split(" ");
			A = Integer.parseInt(request[0]) - 1;
			B = Integer.parseInt(request[1]) - 1;
			nodeArr[A].setLinkNode(nodeArr[B]);
			nodeArr[B].setLinkNode(nodeArr[A]);
			request = null;
		}//end of for i , Line

		for (Node i : nodeArr) {//연결해준 노드들을 오름차순 정렬 처리
			i.LinkNodesSort();
		}//end of for Node i : nodeArr

		//노드 구성 완료...

		bfs(nodeArr[Target-1]);

		for (int i =0; i<NodeHistory.length;i++){
			bw.append(NodeHistory[i]+"\n");
		}
		bw.flush();

		br.close();
		bw.close();

	}//end of Main

	public static void bfs(Node targetNode){
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(targetNode);
		nodeCounter++;
		NodeHistory[targetNode.value-1]=nodeCounter;//타깃 노드의 기록에 방문기록
		Node target;
		while(!queue.isEmpty()){
			target = queue.poll();
			for(Node i : target.nodes){
				if(NodeHistory[i.value-1]==0){//처음 방문했다면
					nodeCounter++;
					NodeHistory[i.value-1]=nodeCounter;//방문기록
					queue.add(i);
				}//end of if
			}//end of for Node i : target.nodes
		}//end of while !queue.isEmpty()
	}
	static class Node {
		int value;
		ArrayList<Node> nodes = new ArrayList<>();

		Node(int initValue) {
			this.value = initValue;
		}//end of constructor Node(init)

		public void setLinkNode(Node LinkNode) {
			nodes.add(LinkNode);
		}

		public void LinkNodesSort() {
			nodes.sort(
					(o1, o2) -> {
						if (o1.value > o2.value) return 1;
						else if (o1.value < o2.value) return -1;
						else return 0;
					});
		}//end of method LinkNodesSort()

	}//end of class Node
}
