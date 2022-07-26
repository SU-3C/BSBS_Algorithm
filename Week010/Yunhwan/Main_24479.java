package Algorithm10;

import java.io.*;
import java.util.ArrayList;

public class Main_24479 {
	static int[] NodeHistory;
	static int nodeOrderCount = 0;

	public static void main(String[] args) throws IOException {
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

		for (Node i : nodeArr) {//연결해준 노드들 오름차순 정렬 처리
			i.LinkNodesSort();
		}//end of for Node i : nodeArr

		//노드 구성 완료...

		dfs(nodeArr[Target - 1]);//DFS탐색

		for (int i = 0; i < NodeHistory.length; i++) {
			bw.append(NodeHistory[i] + "\n");
		}
		bw.flush();

		br.close();
		bw.close();


	}//end of main

	public static void dfs(Node targetNode) {
		if (NodeHistory[targetNode.value - 1] == 0) {//방문 안했으면
			nodeOrderCount++;
			NodeHistory[targetNode.value - 1] = nodeOrderCount;//방문 처리
		}
		for (Node i : targetNode.nodes) {//타겟노드의 연결된 노드를 조회하는 반복문
			if (NodeHistory[i.value - 1] == 0) {//방문 안했으면 실행
				nodeOrderCount++;//방문 순서 추가
				NodeHistory[i.value - 1] = nodeOrderCount;//방문 처리
				dfs(i);
			}
		}//end of for Node i : targetNode.nodes


	}//end of dfs()


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
