package Algorithm11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_24481 {
	public static void main(String[] args)throws IOException {
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
		for (Node i :nodes)i.sort();

		dfs(nodes[StartTarget-1]);
		for (Node i: nodes){
			System.out.println(i.deep);
		}
	}//end of main


	public static void dfs(Node targetNode){
		if (targetNode.deep==-1)targetNode.deep=0;
		for (Node i: targetNode.linkNode){
			if(i.deep==-1){
				i.deep = targetNode.deep+1;
				dfs(i);
			}//end of  for-if
		}//end of for

	}//end of dfs


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
		public void sort(){
			linkNode.sort((o1,o2)->{
				if(o1.value>o2.value)return 1;
				else if(o1.value<o2.value)return -1;
				else return 0;
			});
		}
	}//end of Node static class
}
