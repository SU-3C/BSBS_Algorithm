import java.util.*;
import java.io.*;
 
public class Main {
    static int n,m,cnt;
    //몇번째 방문인지 
    public static int[] visted;
    //연결된 노드
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
 
    public static void dfs(int x){
    	//순차 정함 
        visted[x]=cnt;
        for(int i=0;i<graph.get(x).size();i++){
        	//연결된 노드
            int y = graph.get(x).get(i);
            //방문을 안했을 경우
            if(visted[y]==0){
            	//순차 증가 , 실행순서 매기기
                cnt++; 
                //dfs 실행
                dfs(y);
            }
        }
    }
 
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
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<Integer>());
        }
        //연결된 노드 체크
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //노드마다 오름차순 ( 문제조건)
        for(int i=0;i<graph.size();i++){
            Collections.sort(graph.get(i));
        }
        cnt=1;
        visted= new int[n+1];
        dfs(r);
        for(int i=0;i<visted.length;i++){
            if(i!=0) System.out.println(visted[i]);
        }
    }
}
