package Algorithm12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1991 {
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int NodeCount = Integer.parseInt(br.readLine());
		Node[] givenNodes = new Node[NodeCount];//노드 갯수


		for (int i = 0; i < NodeCount; i++) {
			givenNodes[i] = new Node((char) (i + 65));
		}//end of for = Node생성

		String[] NodeLink;
		for (int i = 0; i < NodeCount; i++) {
			NodeLink = br.readLine().split(" ");
			int targetNode = NodeLink[0].charAt(0) - 65;
			givenNodes[targetNode].preNode =
					NodeLink[1].charAt(0) == '.' ?
							null : givenNodes[(NodeLink[1].charAt(0) - 65)];
			givenNodes[targetNode].postNode =
					NodeLink[2].charAt(0) == '.' ?
							null : givenNodes[(NodeLink[2].charAt(0) - 65)];
			NodeLink = null;
		}//end of for NodeLinking
		prefix(givenNodes[0]);
		System.out.println(result);
		result = new StringBuilder();

		inorderfix(givenNodes[0]);
		System.out.println(result);
		result = new StringBuilder();

		postfix(givenNodes[0]);
		System.out.println(result);

	}//end of main method()


	static void prefix(Node target) {
		result.append(target.value);
		if(target.preNode!=null){
			prefix(target.preNode);
		}
		if(target.postNode!=null){
			prefix(target.postNode);
		}
	}//end of  prefix

	static void inorderfix(Node target) {
		if(target.preNode!=null){
			inorderfix(target.preNode);
		}
		result.append(target.value);
		if(target.postNode!=null){
			inorderfix(target.postNode);
		}
	}//end of inorderfix

	static void postfix(Node target) {
		if(target.preNode!=null){
			postfix(target.preNode);
		}
		if (target.postNode!=null){
			postfix(target.postNode);
		}
		result.append(target.value);
	}//postfix

	static class Node {
		private char value;
		private Node preNode;
		private Node postNode;

		Node(char initNodeValue) {
			this.value = initNodeValue;
		}//constructor

	}//end of Node class
}// end of public class
//DBAECFG