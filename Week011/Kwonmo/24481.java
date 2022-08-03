
import java.util.*;
import java.io.*;
 
public class Main_24481 { 
    static int n,m;
    public static boolean[] visited;
    //연결된 노드
    static int []depth;
	static int dep=0;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //정점의 개수
        n = Integer.parseInt(st.nextToken());
        //간선의 개수
        m = Integer.parseInt(st.nextToken());
        //처음 노드
        int r =Integer.parseInt(st.nextToken());
        //연결된 노드 초기화
        depth=new int[n+1];
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<Integer>());
        }
        //연결된 노드 체크
        visited = new boolean[n+1]; //방문처리 배열
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u); //양방향 그래프에 정점 연결 get메소드는 노션참조
        }
      //노드마다 오름차순 ( 문제조건)
//        for(int i=0;i<graph.size();i++){
//           Collections.sort(graph.get(i));
//       }
        for(int i=0;i<n;i++) depth[i]= -1;
        dfs(r);
        for(int i=1;i<n+1;i++) {
    		System.out.println(depth[i]);
    	}
        
    }
    public static void dfs(int x){
    	visited[x] = true;
    	depth[x]=++dep;
        for(int i=0;i<graph.get(x).size();i++){
        	//연결된 노드
            int y = graph.get(x).get(i);
            //방문을 안했을 경우
            if(visited[y]==false){
                //dfs 실행
                dfs(y);
                
            }
        }
    }
}
