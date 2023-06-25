import java.io.*;
import java.util.*;

public class Main {
	static int N,M,R;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();	
    //이중 arrayList(이차원배열 느낌)을 통해 arraylist형 상자 안에 arraylist형 상자 여러개가 있는 느낌

	static boolean[] visited;	//방문 확인 배열
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //그래프 값 저장
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
        
    	visited = new boolean[N+1]; //방문처리 배열
        
    	for(int i=0;i<=N;i++)
    		graph.add(new ArrayList<>());
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		graph.get(u).add(v);
    		graph.get(v).add(u);
    	}
    	bfs(R);		//너비 우선 탐색 수행
    	
    	bw.flush();		//결과 출력
    	bw.close();
    	br.close();
    }
    //너비 우선 탐색하는 함수
    static void bfs(int start) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(start);
    	visited[start] = true;	//방문 확인
    	int []depth=new int[N+1];
        int dep=0;
    	

    	for(int i=1;i<=N;i++) depth[i]= -1;
    	
    	while(!queue.isEmpty()) {//큐가 빌때까지 반복
    		int size = queue.size();
    		while(size-- > 0) {//한 사이클씩 돌면서 각 노드의 깊이를 담아야하니까 while문이 하나 더 필요함
    			int vertex = queue.poll(); //큐에서 정점하나씩 꺼내고 삭제
    			depth[vertex]=dep;
    			for(int next : graph.get(vertex)) {	//인접 정점 탐색 (그래프나 배열같은 자료구조는 foreach문이 좋대서 한번 for each문으로 까불어봄)
    				if(!visited[next]) {	//방문했는지 확인
    					visited[next] = true;	//방문 확인
    					queue.add(next);
    				}
    			}
    		}
    		dep++;
    	}
    	
    	for(int i=1;i<=N;i++) {
    		System.out.println(depth[i]);
    	}
    }
}
