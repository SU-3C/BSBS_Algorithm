package Week10;

import java.util.*;

public class BOJ_Main_1260 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        //정점,간선,시작번호 받는 입력 값

        boolean checked[] = new boolean[n + 1];

        LinkedList<Integer>[] bList = new LinkedList[n + 1];

        //방문한 것을 체크, 간선들이 이동하려는 것을 저장하는 수

        for (int i = 0; i <= n; i++) {
            bList[i] = new LinkedList<Integer>();
        }

        //기존 배열에 새로운 배열에 저장한다.
        for (int i = 0; i < m; i++) {

            int m1 = sc.nextInt();
            int m2 = sc.nextInt();

            bList[m1].add(m2);
            bList[m2].add(m1);
        }
        //간선은 서로 양방향이라 이어줘야한다.
        for (int i = 1; i <= n; i++) {
            Collections.sort(bList[i]);
        }
        //이어진 간선들을 오름차순으로 정리해야한다 왜냐면
        //나중에 이어지는 방문 체크했을때 오류가 나지 않게

        dfs(v, bList, checked);
        System.out.println();
        Arrays.fill(checked,false);
        // 체크된 리스트 때문에 결과가 나오지 않아 모두 false시켜주고 다시 시작시킨다.
        bfs(v, bList, checked);

    }

    public static void dfs(int v, LinkedList<Integer>[] bList, boolean[] checked) {
        checked[v] = true;
        System.out.print(v + " ");
        //반복자를 사용하여 요소들을 읽는다. 각각의 배열의 요소들을
        Iterator<Integer> start = bList[v].listIterator();
        while (start.hasNext()) {
            int w = start.next();
            if (!checked[w]) {
                dfs(w, bList, checked); //기존 정점 멈추고 새로운 정점으로 가서 반복하는 함수
            }
        }

    }

    public static void bfs(int v, LinkedList<Integer>[] bList, boolean[] checked) {
        Queue<Integer> queue = new LinkedList<Integer>();
        checked[v] = true;
        queue.add(v);


        while (queue.size() != 0) {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> start = bList[v].listIterator();
            while (start.hasNext()) {
                int w = start.next();
                if (!checked[w]) {
                    checked[w] =true;
                    queue.add(w);
                }
            }

        }

    }
}
