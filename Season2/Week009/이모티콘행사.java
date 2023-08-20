package Programmers.level2;

public class EmoticonSale {

    static int lastPay = 0;
    static int lastJoinService = 0;

    public static void main(String[] args) {
        int[][] users = new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = new int[]{1300, 1500, 1600, 4900};
        EmoticonSale sol = new EmoticonSale();
        int[] solution = sol.solution(users, emoticons);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] discount = {40, 30, 20, 10};
        int length = discount.length;
        generatePermutations(users, discount, emoticons, length);
        answer[0] = lastJoinService;
        answer[1] = lastPay;
        return answer;
    }


    public static void generatePermutations(int[][] users, int[] discount, int[] emoticons, int length) {
        int[] permutation = new int[emoticons.length];
        generatePermutationsUtil(discount, permutation, 0, length, emoticons.length, emoticons, users);
    }

    public static void generatePermutationsUtil(int[] emoticons, int[] permutation, int depth, int n, int r, int[] pay, int[][] users) {
        if (depth == r) {
            // 현재 순열 출력
            int plusServiceJoin = 0;
            int maxEmoticonPay = 0;
            for (int[] user : users) {
                int discountSum = 0;
                for (int i = 0; i < permutation.length; i++) {
                    if (user[0] <= permutation[i]) {
                        discountSum += pay[i] - (pay[i] * (permutation[i] / 100.0));
                    }
                }

                if (user[1] <= discountSum) {
                    plusServiceJoin++;
                } else {
                    maxEmoticonPay += discountSum;
                }

                if (lastJoinService < plusServiceJoin) {
                    lastJoinService = plusServiceJoin;
                    lastPay = maxEmoticonPay;
                } else {
                    if (lastJoinService == plusServiceJoin && lastPay < maxEmoticonPay) {
                        lastPay = maxEmoticonPay;
                    }
                }
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            permutation[depth] = emoticons[j];
            generatePermutationsUtil(emoticons, permutation, depth + 1, n, r, pay, users);
        }
    }



}
