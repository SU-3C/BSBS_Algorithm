package programmers;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Programmers {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        for(int i : sol.solution(id_list, report, k)){
            System.out.print(i + "  ");
        }
    }
}

class Member {
    public List<String> report;
    public int reportCnt;
    public Member(){
        report = new ArrayList<>();
        reportCnt = 0;
    }

    public boolean doReport(String report){
        if (!this.report.contains(report)) {
            this.report.add(report);
            return true;
        }
        else {
            return false;
        }
    }

    public int checkMailSend(List<String> blockList){
//        List<String> matchList = this.report.stream().filter(o -> blockList.stream()
//                .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
//        return matchList.size();
        int sum = 0;
        for(String reporter : this.report){
            if (blockList.contains(reporter))
                sum++;
        }
        return sum;
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Member> member = new HashMap<>();
        List<String> blockUser = new ArrayList<>();
        for(String id : id_list){
            member.put(id, new Member());
        }
        for(String rep : report){
            String[] repSp = rep.split(" ");
            Member reporter = member.get(repSp[0]);
            Member respondant = member.get(repSp[1]);
            if(reporter.doReport(repSp[1])){
                respondant.reportCnt++;
                if (respondant.reportCnt >= k){
                    blockUser.add(repSp[1]);
                }
            }
        }
        int idx = 0;
        for (String id : id_list){
            answer[idx] = member.get(id).checkMailSend(blockUser);
            idx++;
        }
        return answer;
    }
}
