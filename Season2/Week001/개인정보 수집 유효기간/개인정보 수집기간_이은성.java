 public int[] solution(String today, String[] terms, String[] privacies) {
        int index = 1;
        List<Integer> answerList = new ArrayList<>();
        for (String term : terms) {
            String[] splitTerms = term.split(" ");
            String splitTerm = splitTerms[0];
            int splitTermDate = Integer.parseInt(splitTerms[1]);
            termsDates.put(splitTerm, splitTermDate);
        }

        for (String privacy : privacies) {
            String[] splitPrivacy = privacy.split(" ");
            String dateCalculator = DateCalculator(splitPrivacy);
            if (!isDateValidator(today, dateCalculator)) {
                answerList.add(index);
            }
            index++;
        }


        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;

    }

    public String DateCalculator(String[] splitPrivacy) {
        StringBuilder sb = new StringBuilder();
        String collectionDate = splitPrivacy[0];
        String termsType = splitPrivacy[1];
        Integer validityPeriod = termsDates.get(termsType);

        String[] splitDate = collectionDate.split("\\.");
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);

        month = month + validityPeriod;

        if (month > 12) {
            year = year + (month / 12);
            month = month % 12;
        }

        day = day - 1;

        if (day < 1) {
            month = month - 1;
            day = 28;
        }

        if (month < 1) {
            year = year - 1;
            month = 12;
        }

        return sb.append(year).append(".").append(month).append(".").append(day).toString();
    }

    public boolean isDateValidator(String today, String before) {
        String[] todaySplit = today.split("\\.");
        String[] splitBeforeDate = before.split("\\.");

        for (int i = 0; i < 3; i++) {
            int beforeDate = Integer.parseInt(splitBeforeDate[i]);
            int todayDate = Integer.parseInt(todaySplit[i]);
            if (beforeDate < todayDate) {
                return false;
            } else if (beforeDate > todayDate) {
                return true;
            }
        }
        return true;
    }
