package Programmers.level1;


import java.util.Arrays;

/*
 * @link{https://school.programmers.co.kr/learn/courses/30/lessons/258712}
 */
public class MostReceivedGifts {
    public static void main(String[] args) {
        String[] friends = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        MostReceivedGifts mostReceivedGifts = new MostReceivedGifts();
        int result = mostReceivedGifts.solution(friends, gifts);
        System.out.println("result = " + result);
    }

    public int solution(String[] friends, String[] gifts) {
        int[][] tradeInfo = new int[friends.length][friends.length];
        setGiftMapping(friends, gifts, tradeInfo);
        return compareSendAndReceive(friends, tradeInfo);
    }

    /**
     * 두 사람이 선물을 주고받은 기록이 있다면
     * 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
     */
    private int compareSendAndReceive(String[] friends, int[][] tradeInfo) {
        int answer = 0;

        for (int i = 0; i < tradeInfo.length; i++) {
            int tempAnswer = 0;
            for (int j = 0; j < tradeInfo.length; j++) {
                if (i != j && tradeInfo[i][j] > tradeInfo[j][i]) {
                    tempAnswer++;
                } else if (i != j && tradeInfo[i][j] == tradeInfo[j][i]) {
                    tempAnswer = giftComparisonIndex(friends, tradeInfo, i, j, tempAnswer);
                }
            }
            if (answer < tempAnswer) {
                answer = tempAnswer;
            }
        }
        return answer;
    }

    /**
     * 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면
     * 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
     */
    private int giftComparisonIndex(String[] friends, int[][] tradeInfo, int i, int j, int tempAnswer) {
        int compareA1Friend = 0, compareA2Friend = 0, compareB1Friend = 0, compareB2Friend = 0;
        for (int k = 0; k < friends.length; k++) {
            compareA1Friend += tradeInfo[i][k];
            compareA2Friend += tradeInfo[k][i];
            compareB1Friend += tradeInfo[j][k];
            compareB2Friend += tradeInfo[k][j];
        }
        int compareAFriend = compareA1Friend - compareA2Friend;
        int compareBFriend = compareB1Friend - compareB2Friend;
        if (compareAFriend > compareBFriend) {
            tempAnswer++;
        }
        return tempAnswer;
    }

    /**
     * friend별 보낸사람과 받는사람에 대한 정보를 저장하는 메서드입니다.
     */
    private void setGiftMapping(String[] friends, String[] gifts, int[][] tradeInfo) {
        for (String gift : gifts) {
            int sentPeople = Arrays.asList(friends).indexOf(gift.split(" ")[0]);
            int receivedPeople = Arrays.asList(friends).indexOf(gift.split(" ")[1]);
            tradeInfo[sentPeople][receivedPeople]++;
        }
    }
}
