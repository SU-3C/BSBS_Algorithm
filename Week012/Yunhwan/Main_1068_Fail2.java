package Algorithm12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1068 {
	static int[] NodesParent;
	static int[][] NodesChild;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalNode = Integer.parseInt(br.readLine());
		String[] parentInfo = br.readLine().split(" ");
		int deleteNode = Integer.parseInt(br.readLine());
		br.close();

		NodesParent = new int[totalNode];
		NodesChild = new int[totalNode][totalNode];
		Arrays.fill(NodesParent, -1);
		for (int[] i : NodesChild)
			Arrays.fill(i, -1);

//노드 부모-자식 값 설정 작업
		for (int i = 0; i < totalNode; i++) {//주어진 조건의 부모 값 입력
			int parent = Integer.parseInt(parentInfo[i]);
			if (parent != -1) {
				NodesParent[i] = parent;
				NodesChild[parent][i] = 1;
			}//end of if
		}//end of for

////노드 삭제 작업 (부모 배열과 자식배열에서 해당 노드의 값을 찾아서 -1로 초기화)
		NodesParent[deleteNode] = -1;
		for (int nodeParentValue : NodesParent) {
			if (nodeParentValue == deleteNode)//부모값이 삭제하려는 노드값과 같으면 -1로 초기화
				nodeParentValue = -1;
		}//end of for

		for (int[] nodeChileValue : NodesChild) {//자식노드배열 행단위 반복
			for (int i=0; i<nodeChileValue.length;i++) {//자식노드배열 행안의 열의 요소 반복
				if (i == deleteNode) {
					nodeChileValue[i] = -1;
					break;//찾았으면 해당 행 요소 반복종료
				}
			}
		}


		findRoot(0);//root값을 찾기
		leafCounter(root);
		System.out.println(leaf);

	}//end of main

	static int root;

	static void findRoot(int target) {
		if (NodesParent[target] == -1) root = target;
		else findRoot(NodesParent[target]);
	}

	static int leaf;

	static void leafCounter(int target) {
		int count = 0;
		for (int i=0; i<NodesChild[target].length;i++) {//해당 노드 행의 열요소를 조회
			if (NodesChild[target][i] != -1) {//연결된게 있을 때
				leafCounter(i);//재귀 함수로 dfs시전
				count++;
			}
		}//end of for
		if (count == 0) leaf++;//자식이 없을 때 leaf로 인지
	}//end of leafCounter

}
