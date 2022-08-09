package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_1991{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i, n = Integer.parseInt(br.readLine());
		Tree t = new Tree();
		char data[];
		for(i=0;i<n;i++){
			data = br.readLine().replaceAll(" ", "").toCharArray();
			//StringTokenizer는 String형이라 char형으로 다루려고 씀
			t.add(data[0], data[1], data[2]);
		}//한 라인별로 트리에 추가하여 구성 이때 root가 기존에 있던값인지 아닌지 판별해주는 search필요
		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
		br.close();
	}
}
class Node{
	char data;
	Node left, right;
	public Node(char data){ this.data = data; }
}

class Tree{
	Node root;
	
	public void add(char data, char leftData, char rightData){
		if(root==null){
			if(data!='.') root = new Node(data); // 부모노드생성
			if(leftData!='.') root.left = new Node(leftData); //왼쪽자식노드생성
			if(rightData!='.') root.right = new Node(rightData); //오른쪽자식노드생성
		}
		else search(root, data, leftData, rightData); //값이 들어있으면 노드순회
	}
	
	//어느 위치에 추가할 것인지 위치를 찾아주는 search()메서드
	private void search(Node root, char data, char leftData, char rightData){
		//재귀를 사용하므로 도착한 노드가 null이면 종료 = 삽입 위치를 찾지 못한 경우
		if(root==null) return;
		//위치를 찾았으면
	    else if(root.data==data){
	    	//'.'이 아닌 경우에 한해서 좌, 우 노드 생성 후 데이터 삽입
		    if(leftData!='.') root.left = new Node(leftData);
		    if(rightData!='.') root.right = new Node(rightData);
	    }
	    else{
	    	//아직 찾지 못했고, 탐색할 노드들이 남아있는 경우
		    search(root.left, data, leftData, rightData);
		    search(root.right, data, leftData, rightData);
	    }
    }
	
	public void preorder(Node root){
		// 전위순회: 중앙->좌->우 
		System.out.print(root.data);
		if(root.left!=null) preorder(root.left);
		if(root.right!=null) preorder(root.right);
	}
	
	public void inorder(Node root){
		// 중위순회: 좌->중앙->우 
		if(root.left!=null) inorder(root.left);
		System.out.print(root.data);
		if(root.right!=null) inorder(root.right);
	}
	
	public void postorder(Node root){
		// 후위순회: 좌->우->중앙 
		if(root.left!=null) postorder(root.left);
		if(root.right!=null) postorder(root.right);
		System.out.print(root.data);
	}
}
