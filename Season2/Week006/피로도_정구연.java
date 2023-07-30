class Solution {
    int score = -1;
    public int solution(int k, int[][] dungeons) {
        permute(k, dungeons, 0);
        return score;
    }
    public void permute(int k, int[][] arr, int currentIndex) {
        if (currentIndex == arr.length - 1) {
            //System.out.println(score(k, arr));
            int s = score(k, arr);
            score = (score < s)?s:score;
        } else {
            for (int i = currentIndex; i < arr.length; i++) {
                swap(arr, currentIndex, i);
                permute(k, arr, currentIndex + 1);
                swap(arr, currentIndex, i);
            }
        }
    }

    public void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int score(int k, int[][] dgSeq){
        int score = 0;
        for(int i = 0; i < dgSeq.length; i++){
            if (dgSeq[i][0] <= k){
                score++;
                k -= dgSeq[i][1];
            } else {
                break;
            }
        }
        return score;
    }
}