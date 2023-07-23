class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0, day_bef = 0;
        Queue<Integer> pQ = new LinkedList<>(), sQ = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            pQ.add(progresses[i]);
            sQ.add(speeds[i]);
        }

        int cnt = 0;
        while(!pQ.isEmpty()){
            int p = pQ.poll();
            int s = sQ.poll();
            while (p < 100){
                if (p + s * day >= 100){
                    System.out.println(day_bef + " : " + day);
                    if (day_bef > 0 && day_bef < day) {
                        l.add(cnt);
                        cnt = 0;
                    }
                    cnt++;
                    day_bef = day;
                    break;
                }else {
                    day++;
                }
            }
        }
        l.add(cnt);
        int[] answer = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}