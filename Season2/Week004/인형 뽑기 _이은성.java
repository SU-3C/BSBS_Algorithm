   public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        //뽑기 부분
        for (int move : moves) {
            int pickLine = move - 1;
            answer = pickLogic(board, answer, stack, pickLine);

        }
        return answer;
    }

    private int pickLogic(int[][] board, int answer, Stack<Integer> stack, int pickLine) {
        for (int j = 0; j < board.length; j++) {
            int block = board[j][pickLine];
            if (block == 0) {
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == block) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(block);
            }

            board[j][pickLine] = 0;
            break;
        }

        return answer;
    }
