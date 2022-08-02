package Algorithm11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_24446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NodeLineStart = br.readLine().split(" ");
		int NodeTotal = Integer.parseInt(NodeLineStart[0]);
		int LineTotal = Integer.parseInt(NodeLineStart[1]);
		int StartTarget = Integer.parseInt(NodeLineStart[2]);
		Node[] nodes = new Node[NodeTotal];

		for (int i = 1; i <= NodeTotal; i++) {
			nodes[i-1] = new Node(i);
		}//end of for int i = 0

		String[] linkInfo;
		int A, B;
		for (int i = 0; i < LineTotal; i++) {
			linkInfo = br.readLine().split(" ");
			A = Integer.parseInt(linkInfo[0]) - 1;
			B = Integer.parseInt(linkInfo[1]) - 1;
			nodes[A].setLinkNode(nodes[B]);
			nodes[B].setLinkNode(nodes[A]);
			linkInfo = null;
		}//end of for LineTotal

		bfs(nodes[StartTarget-1]);
		for(Node i: nodes){
			System.out.println(i.deep);
		}

	}//end of Main

	public static void bfs(Node TargetNode) {
		LinkedList<Node> queue = new LinkedList<>();
		//대상이되는 첫 node 레벨 설정
		TargetNode.deep=0;
		int level;
		queue.add(TargetNode);//해당 노드를 queue에 담음

		Node targetNode;//bfs탐색에 사용되는 queue에서 빼낸 값을 담는 참조변수
		//BFS 반복
		while(!queue.isEmpty()){
			targetNode = queue.poll();//큐에서 node를 꺼냄
			level = targetNode.deep;//꺼낸 node의 레벨을 담고
			for(Node i:targetNode.linkNode){//대상이 되는 노드에 연결된 노드에게
				if(i.deep==-1){//방문 안했으면
					i.deep=level+1;//연결된 하위 노드의 레벨설정
					queue.add(i);//설정하고 큐에 추가
				}
			}//end of for Node i
		}//end of while

	}

	static class Node {
		int value;
		LinkedList<Node> linkNode = new LinkedList<>();

		int deep = -1;

		public Node(int initValue) {
			this.value = initValue;
		}

		public void setLinkNode(Node conNode) {
			linkNode.add(conNode);
		}

	}
}
