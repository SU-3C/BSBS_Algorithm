public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> carTime = new HashMap<>();
        Map<String, Integer> carMap = new HashMap<>();
        Map<String, Integer> carFee = new TreeMap<>();
        int basicHour = fees[0];
        int basicFee = fees[1];
        int unitHour = fees[2];
        int unitFee = fees[3];

        String lastTime = "23:59";

        for (String record : records) {
            String[] splitRecords = record.split(" ");
            String time = splitRecords[0];
            String carNumber = splitRecords[1];
            String InOutStatus = splitRecords[2];
            if (InOutStatus.equals("IN")) {
                carMap.put(carNumber,toMinutes(time));
            } else if (InOutStatus.equals("OUT")) {

                int totalMinutes = toMinutes(time) - carMap.get(carNumber);
                if(!carTime.containsKey(carNumber)){
                    carTime.put(carNumber,totalMinutes);
                }else {
                    Integer value = carTime.get(carNumber);
                    value = value + totalMinutes;
                    carTime.put(carNumber,value);
                }
                carMap.remove(carNumber);

            }

        }
        // 마지막 입차 레코드 처리
        for (String carNumber : carMap.keySet()) {
            int totalMinutes = toMinutes(lastTime) - carMap.get(carNumber);
            Integer value = carTime.getOrDefault(carNumber,0);
            value = value + totalMinutes;
            carTime.put(carNumber,value);
        }

        for (String carNumber : carTime.keySet()) {
            System.out.println("carNumber = " + carTime.get(carNumber));
            Integer totalMinutes = carTime.get(carNumber);
            int totalFee = calculateFee(totalMinutes, basicHour, basicFee, unitHour, unitFee);
            carFee.put(carNumber, totalFee);
        }
        int[] answer = new int[carFee.size()];
        int index = 0;
        for (int fee : carFee.values()) {
            answer[index++] = fee;
        }

        return answer;
    }

    private int calculateFee(int totalMinutes, int basicHour, int basicFee, int unitHour, int unitFee) {
        if (totalMinutes <= basicHour) {
            return basicFee;
        }
        int additionalMinutes = totalMinutes - basicHour;
        int additionalHours = (int) Math.ceil((double) additionalMinutes / unitHour);
        return basicFee + additionalHours * unitFee;
    }

    private int toMinutes(String time) {
        String[] splitTime = time.split(":");
        int splitHour = Integer.parseInt(splitTime[0]);
        int splitMinute = Integer.parseInt(splitTime[1]);
        return splitHour * 60 + splitMinute;
    }
