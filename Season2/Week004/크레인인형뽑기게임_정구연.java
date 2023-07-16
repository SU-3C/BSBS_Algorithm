
import java.util.Stack;

public class Programmers {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(sol.solution(board, moves));
    }
}
class Solution{
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        for(int i : moves){
            int bunny = 0;
            for(int j = 0; j < board.length; j++){
                if(board[j][i-1] > 0){
                    bunny = board[j][i-1];
                    board[j][i-1] = 0;
                    break;
                }
            }
            if (bunny > 0) {
                if (bucket.size() > 0 && bucket.peek() == bunny) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(bunny);
                }
            }
        }
        return answer;
    }
}