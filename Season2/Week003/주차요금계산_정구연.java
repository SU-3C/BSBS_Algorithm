class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        List<Integer> cars = new ArrayList<>();
        Map<String, String> parkMap = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        int basicTime = fees[0], basicFee = fees[1], unitTime = fees[2], unitFee = fees[3];

        for (int i = 0; i < records.length; i++){
            String[] record = records[i].split(" "); // 05:34 5961 IN
            String time = record[0]; // 05:34
            String car = record[1]; // 5961
            String type = record[2]; // IN

            if (type.equals("IN")){
                parkMap.put(car, time);
            }else {
                String[] entryTime = parkMap.remove(car).split(":"); // 05, 34
                int entry = Integer.parseInt(entryTime[0])*60 + Integer.parseInt(entryTime[1]); // 334
                String[] outTime = time.split(":"); // 07, 59
                int out = Integer.parseInt(outTime[0])*60 + Integer.parseInt(outTime[1]); // 479
                int parkTime = out - entry; // 145
                if (timeMap.containsKey(car)){
                    int befParkTime = timeMap.get(car);
                    timeMap.put(car, befParkTime + parkTime);
                }
                else {
                    timeMap.put(car, parkTime);
                }
            }
        }
        for (Map.Entry<String, String> keyPair : parkMap.entrySet()){
            String car = keyPair.getKey();
            String[] entryTime = parkMap.get(car).split(":");
            int entry = Integer.parseInt(entryTime[0])*60 + Integer.parseInt(entryTime[1]);
            String[] outTime = "23:59".split(":");
            int out = Integer.parseInt(outTime[0])*60 + Integer.parseInt(outTime[1]);
            int parkTime = out - entry;
            if (timeMap.containsKey(car)){
                int befParkTime = timeMap.get(car);
                timeMap.put(car, befParkTime + parkTime);
            }
            else {
                timeMap.put(car, parkTime);
            }
        }

        for (Map.Entry<String, Integer> keyPair : timeMap.entrySet()) {
            String car = keyPair.getKey();
            int time = keyPair.getValue();
            int fee = basicFee;
            if (time > basicTime) {
                time = time - basicTime;
                fee += (time / unitTime)*unitFee + (time % unitTime > 0 ? 1:0) * unitFee;
            }
            timeMap.put(car, fee);
            cars.add(Integer.parseInt(car));
        }
        cars.sort(Comparator.naturalOrder());
        answer = new int[cars.size()];
        for(int i = 0; i < cars.size(); i++){

            answer[i] = timeMap.get(String.format("%04d", cars.get(i)));
        }
        return answer;
    }
}