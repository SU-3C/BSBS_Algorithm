import java.util.HashMap;
import java.util.Map;

class Solution {
     public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> totalClothes = new HashMap<>();
      
        for (String[] cloth : clothes) {
            totalClothes.put(cloth[1], totalClothes.getOrDefault(cloth[1], 0) + 1);
        }
        for (int value : totalClothes.values()) {
            answer *= value+1;
        }


        return answer-1;
    }
}
