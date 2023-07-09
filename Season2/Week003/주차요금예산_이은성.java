public int[] solution(int[] fees, String[] records) {
        Map<String, String> carNum = new HashMap<>();
        Map<String, Integer> carTime = new HashMap<>();
        Map<String, Integer> carFee = new TreeMap<>();
        int basicHour = fees[0];
        int basicFee = fees[1];
        int unitHour = fees[2];
        int unitFee = fees[3];

        for (int i = 0; i < records.length; i++) {
            String[] splitRecords = records[i].split(" ");
            if (!carNum.containsKey(splitRecords[1])) {
                carNum.put(splitRecords[1], splitRecords[0]);

            } else {
                String basicTime = carNum.get(splitRecords[1]);
                String unitTime = splitRecords[0];
                String[] splitBasicTime = basicTime.split(":");
                String[] splitUnitTime = unitTime.split(":");
                int hour = Math.abs((Integer.parseInt(splitBasicTime[0]) * 60 + Integer.parseInt(splitBasicTime[1])) - (Integer.parseInt(splitUnitTime[0]) * 60 + Integer.parseInt(splitUnitTime[1])));
                if (!carTime.containsKey(splitRecords[1])) {
                    carTime.put(splitRecords[1], hour);
                    carNum.remove(splitRecords[1]);
                } else {
                    Integer carMinute = carTime.get(splitRecords[1]);
                    carMinute += hour;
                    carTime.put(splitRecords[1], carMinute);
                    carNum.remove(splitRecords[1]);
                }

            }
        }
        for (Map.Entry<String, String> entry : carNum.entrySet()) {
            String lastCarTime = carNum.get(entry.getKey());
            String lastTime = "23:59";
            String[] splitCarTime = lastCarTime.split(":");
            String[] splitLastTime = lastTime.split(":");
            int hour = Math.abs((Integer.parseInt(splitCarTime[0]) * 60 + Integer.parseInt(splitCarTime[1])) - (Integer.parseInt(splitLastTime[0]) * 60 + Integer.parseInt(splitLastTime[1])));
            Integer integer = carTime.get(entry.getKey());
            integer = integer + hour;
            carTime.put(entry.getKey(), integer);
        }

        int index = 0;
        int[] answer = new int[carTime.size()];
        for (Map.Entry<String, Integer> entry : carTime.entrySet()) {
            System.out.println("carTime.get(entry.getKey()) = " + carTime.get(entry.getKey()));
            if (carTime.get(entry.getKey()) > basicHour) {
                int fee = basicFee + (((((carTime.get(entry.getKey())-basicHour) + 9) / 10) * 10) / unitHour) * unitFee;
                if (!carFee.containsKey(entry.getKey())) {
                    carFee.put(entry.getKey(), fee);
                } else {
                    Integer firstFee = carFee.get(entry.getKey());
                    int sumFee = firstFee + fee;
                    carFee.put(entry.getKey(), sumFee);
                }

            } else {
                if (!carFee.containsKey(entry.getKey())) {
                    carFee.put(entry.getKey(), basicFee);
                } else {
                    Integer firstFee = carFee.get(entry.getKey());
                    int sumFee = firstFee + basicFee;
                    carFee.put(entry.getKey(), sumFee);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : carFee.entrySet()) {
            answer[index] = carFee.get(entry.getKey());
            index++;
        }


        return answer;
    }
