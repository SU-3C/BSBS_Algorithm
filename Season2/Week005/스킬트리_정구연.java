class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] skArr = skill.split("");
        for(String st : skill_trees){
            int idx = 0;
            boolean flag = false;
            for (String stSkill : st.split("")){
                for(int i = idx; i < skArr.length; i++){
                    if (stSkill.equals(skArr[i])){
                        if (i == idx){
                            idx++;
                        } else if (i > idx ) {
                            flag = true;
                        }
                        break;
                    }
                }
                if (flag){
                    break;
                }
            }
            if (!flag || idx == skArr.length)
                answer++;
        }
        return answer;
    }
}