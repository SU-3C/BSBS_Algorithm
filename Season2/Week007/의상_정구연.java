
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] s : clothes){
            map.put(s[1], map.getOrDefault(s[1], 1) + 1);
        }
        List<Integer> l = new ArrayList<>(map.values());
        for (int i = 0; i < l.size(); i++){
            answer *= l.get(i);
        }
        return answer-1;
    }

//    static Map<String, String> map = new HashMap<>();
//    static int cnt = 0;
//    public int solution(String[][] clothes) {
//        for(int i = 2; i <= clothes.length; i++){
//            func(0, clothes, 0, i);
//        }
//        cnt += clothes.length;
//        return cnt;
//    }
//    public void func(int k, String[][] c, int level, int len){
//        if (level == len){
//
//        } else {
//            for (int i = k; i < c.length; i++){
//                map.put(c[i][0], c[i][1]);
//                func(i + 1, c, level + 1, len);
//                map.remove(c[i][0]);
//            }
//        }
//    }
}