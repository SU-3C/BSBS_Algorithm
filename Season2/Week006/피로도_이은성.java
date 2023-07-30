class Solution {
     static int result=0;
    
   public int solution(int k, int[][] dungeons) {
        permuteRows(dungeons, k, 0);
        return  result;
    }

    public void permuteRows(int[][] matrix, int startFatigue, int currentRow) {
        if (currentRow == matrix.length) {
            int cnt = calculateFatigue(matrix, startFatigue);
            // 모든 행들의 순열이 완성되었으므로 출력
            if (result<cnt){
                result=cnt;
            }
        } else {
            for (int i = currentRow; i < matrix.length; i++) {
                // currentRow와 i 위치의 행을 교환
                swapRows(matrix, currentRow, i);
                // currentRow를 고정한 채로 나머지 행들의 순열을 구함
                permuteRows(matrix, startFatigue, currentRow + 1);
                // 다시 원래대로 돌려놓음
                swapRows(matrix, currentRow, i);
            }
        }
    }

    public void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    public int calculateFatigue(int[][] matrix, int startFatigue) {
        int cnt = 0;
        for (int[] row : matrix) {
            if (startFatigue >= row[0]) {
                startFatigue = startFatigue - row[1];
                cnt++;
            }
        }
        return cnt;
    }
}
