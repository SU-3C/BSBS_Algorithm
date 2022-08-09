package Algorithm12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_1068_Fail {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int totalNode = Integer.parseInt(br.readLine());// first Line
		String[] linkParentNodes = br.readLine().split(" ");//second Line
		int RemoveNodeNumber = Integer.parseInt(br.readLine());

		Node[] givenNodes = new Node[totalNode];
		for (int i = 0; i < totalNode; i++) {
			givenNodes[i]=new Node(i);
		}

		int parentValue;
		for (int i = 0; i < givenNodes.length; i++) {
			parentValue = Integer.parseInt(linkParentNodes[i]);//-1 0 0 2 2 4 4 6 6
			if (parentValue != -1) {//부모가 없으면 -1이므로 부모가 없다면 넘어감 매핑 안해줌
				givenNodes[i].parent = givenNodes[parentValue];
				givenNodes[parentValue].child.add(givenNodes[i]);
			}
		}
		//요소 삭제
		givenNodes[RemoveNodeNumber]=null;

		findRoot(givenNodes[0]);
		leafCounter(givenNodes[root]);
		System.out.println(result);


	}//end of main

	static int root;
	static void findRoot(Node target) {
		if(target==null)return;
		if (target.parent != null)
			findRoot(target.parent);
		else
			root = target.value;

	}

	static int result;

	static void leafCounter(Node target) {
		if (target.child.size() == 0) {//자식없고
			if (target.parent != null) {//부모 있으면
				result++;
			}
			//부모없으면 추가 안함 (메서드 종료)
		} else {//자식 있으면
			for (Node i : target.child) {// 자식 노드들 조회
				leafCounter(i);
			}

		}

	}

	static class Node {
		int value;
		Node parent;
		LinkedList<Node> child = new LinkedList<>();

		Node(int value) {
			this.value = value;
		}

	}
}
//	static void leafCounter(Node target){
//		if(target.child.isEmpty()) {//연결된 자식 노드가 비어져 있다면 leaf로 인식
//			result++;
//		}else{
//			while(!target.child.isEmpty()){//연결된 자식 노드가 없을 때 까지 반복
//				leafCounter(target.child.poll());
//			}
//		}
//	}


//		if (target.child.isEmpty()&&target.parent!=null) {//자식노드가 없고 부모노드가 있다면 leaf로 인식
//			result++;
//		} else {
//			while (!target.child.isEmpty()) {//연결된 자식 노드가 없을 때 까지 반복
//				leafCounter(target.child.poll());
//			}//end of while
//			if(target.parent!=null){//부모가 존재할 때 위로 올려줌
//				leafCounter(target.parent);
//			}
//		}//end of else


//if(target.child.isEmpty()&&target.parent!=null){//자식이 없고 부모가 있으면 부모대상으로 재귀호출
//		result++;
//		leafCounter(target.parent);
//		}else if(!target.child.isEmpty()){//자식이 있고 부모는 몰라
//		while(!target.child.isEmpty()){//자식이 없어질 때까지 자식을 빼서 재귀호출
//		leafCounter(target.child.poll());
//		}
//		if(target.parent!=null) {//자식을 다 빼주고난 후, 부모가 있으면
//		leafCounter(target.parent);
//		}
//		}


//
//
//	static void leafCounter(Node target){
//		if(target==null)return;
//		if(target.visit)return;//방문한 노드이면 종료
//		target.visit=true;
//		if(target.child.isEmpty()){//자식이 없고
//			if(target.parent!=null){//부모가 있으면 더하고 부모 호출
//				result++;
//				leafCounter(target.parent);
//			}
//		}else{//자식이 있으면
//			while(!target.child.isEmpty()){
//				leafCounter(target.child.poll());
//			}
//		}//end of if-else
//	}

//
//
//static class Node {
//	private int value;
//	private Main_1068.Node parent;
//	private LinkedList<Main_1068.Node> child = new LinkedList<>();
//
//	private boolean visit;
//	Node(int value) {
//		this.value = value;
//	}
//
//}

/*
public class Main_1068 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int totalNode = Integer.parseInt(br.readLine());// first Line
		String[] linkParentNodes = br.readLine().split(" ");//second Line
		int RemoveNodeNumber = Integer.parseInt(br.readLine());

//노드 생성
		Node[] givenNodes = new Node[totalNode];
		for (int i = 0; i < totalNode; i++) {
				givenNodes[i] = new Node(i);
		}//end of for generate Node

//노드 매핑
		for(int i =0; i<totalNode; i++){
			int parentNodeValue = Integer.parseInt(linkParentNodes[i]);
			if(parentNodeValue!=-1){//
				givenNodes[i].parent = givenNodes[parentNodeValue];
				givenNodes[parentNodeValue].child.add(givenNodes[i]);
			}
		}//end of for 노드매핑


		for(Node i : givenNodes){//삭제할 노드 처리
			if(i.parent==null||i.parent.value==RemoveNodeNumber){
				i.parent=null;
			}
		}
		for(int i=0; i<givenNodes.length;i++){
			if(i==RemoveNodeNumber)givenNodes[i]=null;
		}

		leafCounter(givenNodes[0]);
		System.out.println(result);

////트리의 조건
//		- 부모-자식 관계가 존재해 레벨이 존재한다.(최상위 노드=Root)
//		- 노드가 N개이면 간선은 N-1개 / 각 레벨 k에 존재하는 노드는 2^k개
//		- 방향성이 존재하고 사이클은 존재하시 않는다.(비순환)
	}//end of main

	static int result;//개수
	static void leafCounter(Node target){
		if(target==null)return;
		if(target.visit)return;//방문한 노드이면 종료
		target.visit=true;
		if(target.child.isEmpty()){//자식이 없고
			if(target.parent!=null){//부모가 있으면 더하고 부모 호출
				result++;
				leafCounter(target.parent);
			}
		}else{//자식이 있으면
			while(!target.child.isEmpty()){
				leafCounter(target.child.poll());
			}
		}//end of if-else
	}


	static class Node {
		private int value;
		private Node parent;
		private LinkedList<Node> child = new LinkedList<>();

		private boolean visit;
		Node(int value) {
			this.value = value;
		}

	}
}
 */