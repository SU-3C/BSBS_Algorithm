public class Programmers {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(16, 16, 2, 1));
    }
}

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int i = 0;
        while (str.length() < t*m){
            str += Integer.toString(i++, n).toUpperCase();
        }
        for (int j = 0; j < t; j++){
            answer += str.charAt(j*m + (p-1));
        }
        return answer;
    }
}