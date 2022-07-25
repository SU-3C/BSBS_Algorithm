package Algorithm10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main_1260 {
	static StringBuilder result = new StringBuilder();
	static boolean[] nodesHistory;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NodeLinkTarget = br.readLine().split(" ");//첫줄 조건을 입력받는 스트링배열

		int NodeCount = Integer.parseInt(NodeLinkTarget[0]);
		int LinkCount = Integer.parseInt(NodeLinkTarget[1]);
		int Target = Integer.parseInt(NodeLinkTarget[2]);

		nodesHistory = new boolean[NodeCount];

		for (int i = 0; i < NodeCount; i++) nodesHistory[i] = false;//노드 방문 기록 초기화
		Node[] Nodes = new Node[NodeCount];

		//노드 생성---------------------------------
		for (int i = 0; i < NodeCount; i++) {
			Nodes[i] = new Node(i + 1);
		}//end of for i

		String[] request;//노드 연결-----------------------
		int A, B;
		for (int i = 0; i < LinkCount; i++) {
			request = br.readLine().split(" ");//노드연결 문장 공백기준으로 잘라서 초기화
			A = Integer.parseInt(request[0]) - 1;//Nodes[]인덱스를 이용하여 노드에 접근하기 위한 초기화
			B = Integer.parseInt(request[1]) - 1;//Nodes[]인덱스가 0부터시작하므로 -1
			Nodes[A].setLinkNode(Nodes[B]);//노드 양방향 연결
			Nodes[B].setLinkNode(Nodes[A]);
			request = null;//노드 연결문장 비워줌
		}//end for i

		//노드 구성 완료 --------------------------------------------------
		dfs(Nodes[Target - 1]);//Nodes[]인덱스가 0부터시작하므로 -1
		System.out.println(result);
		for (int i = 0; i < NodeCount; i++) nodesHistory[i] = false;//노드 방문 기록 초기화
		result = new StringBuilder();//dfs 출력기록 삭제
		bfs(Nodes[Target - 1]);//Nodes[]인덱스가 0부터시작하므로 -1
		System.out.println(result);
		br.close();
	}//end of Main

	public static void dfs(Node targetNode) {
		result.append(targetNode.value + " ");
		nodesHistory[targetNode.value - 1] = true;
		for (Node i : targetNode.nodes) {
			if (!nodesHistory[i.value - 1]) {//노드의 i요소의 방문기록이 false면  //history 인덱스 요소는 node.value 보다 하나 작으므로 -1
				dfs(i);//dfs 메서드를 재귀호출
			}
		}
	}//end of method dfs

	public static void bfs(Node targetNode) {
		if(!nodesHistory[targetNode.value-1]){//타겟 노드의 i요소의 방문기록이 false면 출력 처리
			result.append(targetNode.value + " ");
			nodesHistory[targetNode.value - 1] = true;
		}
		LinkedList<Node> queue = new LinkedList<>();//너비 탐색을 위한 queue
		for (Node i : targetNode.nodes) {//방문기록이 있으면 건너뛰고 큐에 담아주는 반복문
			if (!nodesHistory[i.value - 1]) {//노드의 i요소의 방문기록이 false면 //history 인덱스 요소는 node.value 보다 하나 작으므로 -1
				result.append(i.value + " ");
				nodesHistory[i.value - 1] = true;
				queue.add(i);
			}
		}//end of for Node i:targetNode.nodes
		for (Node i : queue){//담아준 큐의 요소를 조회하여 bfs()메서드 반복
			bfs(i);
		}//end of for Node i:queue

	}
	static class Node {
		int value;
		ArrayList<Node> nodes = new ArrayList<>();

		Node(int initValue) {
			this.value = initValue;
		}

		public void setLinkNode(Node linkNode) {//노드를 연결하고 오름차순으로 nodes를 sort해줌
			nodes.add(linkNode);
			nodes.sort((o1, o2) -> {//람다식으로 Comparator인터페이스 구현
				if (o1.value > o2.value) return 1;
				else if (o1.value < o2.value) return -1;
				else return 0;
			});//end of nodes.sort()
		}
	}//end of class Node


}//end of class Main_1260