package programmers;

import java.util.*;

public class Programmers {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        int[] answer = sol.solution(users, emoticons);
        System.out.println("\nresult : " + answer[0] + ", " + answer[1]);
    }

}
//0. 이모티콘 개수만큼 할인율 조합을 생성 -> 높은 할인율 순으로 40, 40 -> 10, 10 
//1. 고객 별로 할인율 기준에 맞는 이모티콘을 할인 먹인 가격으로 다 더하고 가격 기준 판별
//        a. 가격 기준을 넘어가면 가입여부 + 1
//        b. 넘지 않으면 총 구매 비용 + 해당 고객 구매 비용
//2. 이모티콘 구매 계산이 끝나면 가입여부와 총 구매비용을 비교
//        a. 가입여부가 크면 무조건 수정
//        b. 가입여부가 작거나 같으면 총 구매 비용이 큰 경우로 수정

class Solution {
    int[] discount = new int[] { 40, 30, 20, 10 };
    int[] result = null;
    int[][] users = null;
    int[] emoticons = null;
    int totJoinCnt = 0, totSalesAmt = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        result = new int[emoticons.length];
        this.users = users;
        this.emoticons = emoticons;
        permute( 0);
        return new int[]{totJoinCnt, totSalesAmt};
    }
    private void permute(int cnt) {
        if (cnt == result.length) {
            System.out.print(Arrays.toString(result) + " : ");
            int joinCnt = 0, salesAmt = 0, sumSalesAmt = 0;
            for (int i = 0; i < users.length; i++){
                salesAmt = 0;
                for(int j = 0; j < result.length; j++){
                    if (users[i][0] <= result[j]){
                        salesAmt += emoticons[j] - (emoticons[j]*(result[j]/100.0));
                    }
                }
                if (salesAmt >= users[i][1]) {
                    joinCnt++;
                } else {
                    sumSalesAmt += salesAmt;
                }
            }
            if (joinCnt > totJoinCnt) {
                totJoinCnt = joinCnt;
                totSalesAmt = sumSalesAmt;
            } else {
                if (joinCnt == totJoinCnt && sumSalesAmt > totSalesAmt){
                    totSalesAmt = sumSalesAmt;
                }
            }
            System.out.println(totJoinCnt + ", " + totSalesAmt);
            return;
        }
        for (int i = 0; i < discount.length; i++) {
            result[cnt] = discount[i];
            permute(cnt + 1);
        }
    }
}