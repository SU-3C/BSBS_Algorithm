package week8;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

// 프린터 큐 문제
public class Main_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new LinkedList<>();
        int n=Integer.parseInt(br.readLine());
        String[] in;
        int N,M;
        for (int i=0;i<n;i++){
            in = br.readLine().split(" ");
            N=Integer.parseInt(in[0]);
            M=Integer.parseInt(in[1]);
            in = br.readLine().split(" ");
            dq.clear();
            for(int j=0;j<N;j++){
                dq.add(Integer.parseInt(in[j]));
            }
            int top, cnt=0;
            boolean flag=false; // 로직 실행하기 위한 변수 초기화 작업
            while(true){
                top=dq.poll(); // 가장 위에꺼 우선순위 확인하기 위해 하나 빼냅니다
                if (dq.isEmpty()){ // 뺐는데 비어있다면? 그것이 내가 빼내려고 했던 프린터물임 -> cnt +1하고 출력
                    bw.write(++cnt + "\n");
                    break;
                }
                int k=0; // for 문의 마지막 실행을 판단하기 위한 변수
                for(int j : dq) { // 현재 남아있는 큐에서 더 큰 우선순위가 있나 찾아보기 위한 foreach
                    if (j > top) { // 현재 큐의 원소가 아까 뺀 큐의 첫번째 요소 즉 현재 프린트를 할건지 뒤로 보낼건지 판단하려고 한 그 프린트물 top과 비교
                                    // 현재 큐의 요소가 더 크다면 -> 큐에 더 높은 우선순위의 프린트물이 있다는 뜻
                        dq.add(top); // top 프린트물을 큐의 맨뒤로 보냄
                        // 프린트물의 우선순위가 똑같을 때를 대비하여 처음에 입력받은 우선순위를 계속 다뤄줘야함
                        if ( M==0 ) M=dq.size()-1; //  M이 0일 때는 프린터 대기열의 맨 첫번째 있다는 뜻
                                                    // 근데 지금 대기열에 우선순위가 더 높은 프린터물이 존재한다는 if에 들어왔기때문에 맨뒤로 보내줘야함
                                                    // 맨뒤로 보내줬기때문에 M도 조정해줌 M의 의미는 프린트하려는 프린트물의 위치 정보임
                        else M--; // M이 0이 아니면 맨 앞 프린트물을 맨뒤로 보내줬기때문에 1칸 땡겨줌
                        break; // 우선순위가 높은 프린트물을 한개라도 발견하면 자리 옮겨준 후 그 뒤 프린트물은 비교할 필요 없으니 break
                    }
                    if(k==dq.size()-1){ // foreach에서 마지막 실행일 경우 에서 break로 빠져나가지 못했다면 이 조건문을 만나겠죵??
                                        // 이 의미는 대기열에 더 높은 우선순위의 프린트물이 존재하지 않는다는 뜻
                        cnt++;
                        if (M==0){ // M이 0인 경우란 내가 알고싶은 프린트물이 현재 맨 앞에 있냐는 뜻
                                    // 맨 앞에 있는데 대기열에 더 높은 우선순위의 프린트물이 없다??
                            bw.write(cnt+"\n"); // 바로 출력~
                            flag=true; // while 문을 빠져나가기 위한 flag
                        }
                        else M--; // M이 0이 아니면 대기열에 있다는 뜻이므로 한칸 땡겨줌
                        // 그리고 대기열을 다 돌았는데 더 큰 우선순위가 없으면 큐에 add하지 않으므로 그 프린트 물은 사라져 버리는 것임
                    }
                    k++; // foreach문 실행횟수 비교하기 위한 변수 증가
                }
                if (flag) // flag가 true 일 경우란 내가 알고싶은 프린트물이 출력이 됐을 경우 while 문을 빠져나감
                    break;
            }
        }
        bw.flush();
    }
}



//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    Deque<Integer> dq = new LinkedList<>();
//    int n=Integer.parseInt(br.readLine());
//    String[] in;
//    int N,M;
//        for (int i=0;i<n;i++){
//        in = br.readLine().split(" ");
//        N=Integer.parseInt(in[0]);
//        M=Integer.parseInt(in[1]);
//        in = br.readLine().split(" ");
//        dq.clear();
//        for(int j=0;j<N;j++){
//        dq.add(Integer.parseInt(in[j]));
//        }
//        int top, cnt=0;
//        boolean flag=false;
//        while(true){
//        top=dq.poll();
//        if (dq.isEmpty()){
//        bw.write(++cnt + "\n");
//        break;
//        }
//        int k=0;
//        for(int j : dq) {
//        if (j > top) {
//        dq.add(top);
//        if ( M==0 ) M=dq.size()-1;
//        else M--;
//        break;
//        }
//        if(k==dq.size()-1){
//        cnt++;
//        if (M==0){
//        bw.write(cnt+"\n");
//        flag=true;
//        }
//        else M--;
//        }
//        k++;
//        }
//        if (flag)
//        break;
//        }
//        }
//        bw.flush();