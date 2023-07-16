public String solution(int n, int t, int m, int p) {
        int totalNums = m * t;
        int cnt = 0;
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < totalNums; i++) {
            String hex = Integer.toString(cnt, n);
            hexString.append(hex);
            cnt++;
        }
        StringBuilder answer = new StringBuilder();
        int start = p - 1;
        for (int i = start; i < totalNums; i+=m) {
            String target = String.valueOf(hexString.charAt(i));
            target = target.toUpperCase();
            answer.append(target);
        }

        return answer.toString();
    }
}
