package Algorithm10;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class Main_1260 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] NodeLinkTarget = br.readLine().split("");
		int NodeCount = Integer.parseInt(NodeLinkTarget[0]);
		int LinkCount = Integer.parseInt(NodeLinkTarget[1]);
		int Target = Integer.parseInt(NodeLinkTarget[2]);
		Node[] Nodes = new Node[NodeCount];
		for (int i=0; i<NodeCount; i++){
			Nodes[i] = new Node(i);
		}//end of for i
		String[] request;
		int A, B;
		for (int i =0; i<LinkCount; i++){
			request = br.readLine().split(" ");//노드연결 문장 공백기준으로 잘라서 초기화
			A = Integer.parseInt(request[0]);//인덱스를 이용하여 노드에 접근하기 위한 초기화
			B = Integer.parseInt(request[1]);
			Nodes[A].setLinkNode(Nodes[B]);//노드 양방향 연결
			Nodes[B].setLinkNode(Nodes[A]);
			request = null;//노드 연결문장 비워줌
		}//end for i

	}//end of main
	class DFS{
		public StringBuilder dfs(Node targetNode){
			StringBuilder result =new StringBuilder();
			Stack<Node> dfsStack  = new Stack<>();
			dfsStack.push(targetNode);
			while(!dfsStack.empty()){
				if (dfsStack.peek().nodes.size()==0){

				}
			}

			return result;
		}
	}
	static class Node {
		int value;
		ArrayList<Node> nodes = new ArrayList<>();
		Node(int initValue){
			this.value = initValue;
		}
		public void setLinkNode(Node linkNode){
			nodes.add(linkNode);

		}
	}

}//end of class
