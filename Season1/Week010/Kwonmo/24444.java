import java.io.*;
import java.util.*;

public class Main {
	static int N,M,R;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();	//양방향그래프 값 저장
    //이중 arrayList(이차원배열 느낌)을 통해 arraylist형 상자 안에 arraylist형 상자 여러개가 있는 느낌
	static int[] result;	//순번 저장 배열
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
        
    	result = new int[N+1];
    	visited = new boolean[N+1]; //방문처리 배열
        
    	for(int i=0;i<=N;i++)
    		graph.add(new ArrayList<>());//양방향 그래프에 arraylist공간 만들고 추가
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		graph.get(u).add(v);
    		graph.get(v).add(u);
    	}
        for(int i=1;i<=N;i++){
            Collections.sort(graph.get(i));
        }//오름차순 정렬 왜? 링크드 리스트는 정렬을 해줘야함 큐 형식이기 순때문에 (재귀호출은 순차적으로 호출되지만 큐는 쌓여있는 순서대로 된다 그래서 정렬 필요)
    	bfs(R);		//너비 우선 탐색 수행
    	for(int i=1;i<=N;i++)	//순번 BufferedWriter 저장
    		bw.write(result[i] + "\n");
    	bw.flush();		//결과 출력
    	bw.close();
    	br.close();
    }
    //너비 우선 탐색하는 함수
    static void bfs(int start) {
        int count=1;
    	Queue<Integer> queue = new LinkedList<Integer>();
    	result[start] = count++;	//방문순서 저장
    	visited[start] = true;	//방문 확인
    	queue.add(start);
    	while(!queue.isEmpty()) {//큐가 빌때까지 반복
    		int vertex = queue.poll(); //큐에서 정점하나씩 꺼내고 삭제
    		for(int next : graph.get(vertex)) {	//인접 정점 탐색 (그래프나 배열같은 자료구조는 foreach문이 좋대서 한번 for each문으로 까불어봄)
    			if(!visited[next]) {	//방문했는지 확인
    				visited[next] = true;	//방문 확인
    				result[next] = count++;	//순번 확인
    				queue.add(next);
    			}
    		}
    	}
    	return;
    }
}
