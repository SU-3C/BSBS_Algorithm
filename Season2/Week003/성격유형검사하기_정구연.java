package programmers;

import java.util.HashMap;
import java.util.Map;

public class PersonalityTypeTest {
    public static void main(String[] args) {
        String[] servey = new String[]{"AN", "CF", "MJ", "RT", "NA"};
        int[] choices  = new int[]{5, 3, 2, 7, 5};
        Solution sol = new Solution();
        String solution = sol.solution(servey, choices);
        System.out.println("solution = " + solution);
    }
}

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String type = null;
        int choice = 0;

        Map<String, Integer> indicator = new HashMap<>();
        indicator = initMap(indicator);

        for (int i = 0; i < survey.length; i++){
            type = survey[i];
            choice = 4 - choices[i];
            int val = 0;
            if (choice >= 0){
                type = type.substring(0, 1);
                val = indicator.get(type);
                val += choice;
            }
            else{
                type = type.substring(1);
                val = indicator.get(type);
                val += Math.abs(choice);
            }
            indicator.replace(type, val);
        }

        answer = setResult(indicator);

        return answer;
    }

    private String setResult(Map<String, Integer> map) {
        String result = "";
        result += ( map.get("R") >= map.get("T") )? "R" : "T";
        result += ( map.get("C") >= map.get("F") )? "C" : "F";
        result += ( map.get("J") >= map.get("M") )? "J" : "M";
        result += ( map.get("A") >= map.get("N") )? "A" : "N";
        return result;
    }

    private Map<String, Integer> initMap(Map<String, Integer> map){
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        return map;
    }
}

