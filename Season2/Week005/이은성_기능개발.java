 public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> pocket = new ArrayList<>();
        Queue<Integer> work = new LinkedList<>();
        for (int i = 0; i < speeds.length; i++) {
            int day = 100 - progresses[i];
            int totalDay = day / speeds[i];
            int remainingDays = day % speeds[i];

            if (remainingDays > 0) {
                totalDay++;
            }

            work.add(totalDay);
        }
        int cnt = 1;
        while (true) {
            if (work.size() == 0) break;
            if (work.size() == 1){
                pocket.add(cnt);
                break;
            }
            Integer maxDay = work.poll();
            while (true){
                if (work.size() == 0){
                    pocket.add(cnt);
                    cnt =1;
                    break;
                }
                Integer target = work.element();
                if(maxDay>=target){
                    work.poll();
                    cnt++;
                }else {
                    pocket.add(cnt);
                    cnt = 1;
                    break;
                }
            }
        }
        int[] answer = new int[pocket.size()];
        for (int i = 0; i < answer.length; i++) {
           answer[i] = pocket.get(i);
        }
        return answer;
    }
