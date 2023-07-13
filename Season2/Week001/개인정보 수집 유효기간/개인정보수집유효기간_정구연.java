package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Programmers {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        int[] arr = sol.solution(today, terms, privacies);
        for (int val : arr){
            System.out.print(val + "  ");
        }
    }
}

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        int[] answer = {};
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy.MM.dd");
        Date todayDt = fmt.parse(today);

        Map<String, Integer> termsInfo = setTerms(terms);
        List<Integer> list = new ArrayList<>();

        int idx = 1;
        for(String privacy : privacies){
            String[] privacySp = privacy.split(" ");
            String strCltDt = privacySp[0];
            String strType = privacySp[1];
            int[] arrCltDt = splitStringDate(strCltDt); // 0:yyyy / 1:MM / 2:dd
            int term = termsInfo.get(strType);
            arrCltDt[1] += term;
            arrCltDt[2] -= 1;
            if (arrCltDt[1] > 12){
                arrCltDt[0] = arrCltDt[0] + (int)(arrCltDt[1]/12);
                arrCltDt[1] %= 12;
            }
            if (arrCltDt[2] == 0){
                arrCltDt[2] = 28;
                arrCltDt[1] -= 1;
                if (arrCltDt[1] == 0){
                    arrCltDt[1] = 12;
                    arrCltDt[0] -= 1;
                }
            }
            strCltDt = String.format("%d.%d.%d", arrCltDt[0], arrCltDt[1], arrCltDt[2]);
            Date cltDt = fmt.parse(strCltDt);
            if(todayDt.after(cltDt))
                list.add(idx);
            idx++;
        }
        answer = new int[list.size()];
        int i = 0;
        for(int val : list){
            answer[i++] = val;
        }
        return answer;
    }

    private Map<String, Integer> setTerms(String[] terms){
        Map<String, Integer> termsInfo = new HashMap<>(terms.length);
        for(String term : terms){
            String[] termSplit = term.split(" ");
            termsInfo.put(termSplit[0], Integer.parseInt(termSplit[1]));
        }
        return termsInfo;
    }

    private int[] splitStringDate(String date){
        int[] dateArr = new int[3];
        String[] dtArr = date.split("[.]");
        for(int i = 0; i < dtArr.length; i++){
            dateArr[i] = Integer.parseInt(dtArr[i]);
        }
        return dateArr;
    }
}
