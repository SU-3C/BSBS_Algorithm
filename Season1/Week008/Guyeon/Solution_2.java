package week8;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution_2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for(int i=0;i<answer.length;i++)
            answer[i] = 0;
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<report.length;i++){
            String[] rep = report[i].split(" ");
            String reporter = rep[0];
            String reported = rep[1];
            List<String> list = new ArrayList<>();
            if (map.containsKey(reported)) {
                list = map.get(reported);
                if(list.contains(reporter))
                    continue;
            }
            list.add(reporter);
            map.put(reported, list);
        }
        for(int i=0;i<id_list.length;i++){
            if(map.containsKey(id_list[i])){
                int cnt=map.get(id_list[i]).size();
                if (cnt>=k) {
                    List<String> list = map.get(id_list[i]);
                    for(String s : list){
                        int j=0;
                        for(String id : id_list){
                            if (s.equals(id)) {
                                answer[j]++;
                                break;
                            }
                            j++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}