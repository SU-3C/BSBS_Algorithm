import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi","muzi apeach","frodo apeach","neo apeach"};
        int k =3;
        Solution solution = new Solution();
        int[] answer = solution.solution(id_list, report, k);

        for(int i =0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        report = Arrays.stream(report).distinct().toArray(String[]::new);
        //신고자
        Map<String, Integer> user_id = new HashMap<String, Integer>();
        //메일 보낼 상대
        Map<String, Integer> mail_id = new HashMap<String, Integer>();

        //담을 리스트
        Map<String, List<String>> declaration = new HashMap<String, List<String>>();

        //0으로 초기화 하는작업
        for (String input_id : id_list) {
            user_id.put(input_id, 0);//무지
            mail_id.put(input_id, 0);
            declaration.put(input_id,new ArrayList<>());
        }


        //신고로직
        for (int i = 0; i < report.length; i++) {
            List<String> list = new ArrayList<String>();


            //신고자를 cnt
            //split[0] 신고자 split[1] 신고 당한사람
            String[] split_report = report[i].split(" ");

            int cnt_s = user_id.get(split_report[1]);
            user_id.put(split_report[1], cnt_s + 1);

            list.add(split_report[0]);

          //키가 있으면 함께 추가 아니면 그냥 추가
            if(declaration.containsKey(split_report[1])){
                List<String> list1 = declaration.get(split_report[1]);
                list1.addAll(list);
            }else {
                declaration.put(split_report[1], new ArrayList<>(list));
            }
            list.clear();
        }

        //메일 보내는 리스트 보면됨
        for (int i = 0; i < mail_id.size(); i++) {
            if (k <= user_id.get(id_list[i])) {
                for (String split : declaration.get(id_list[i])) {
                    int num = mail_id.get(split);
                    mail_id.put(split, num+1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < mail_id.size(); i++) {
            answer[i] = mail_id.get(id_list[i]);
        }

        return answer;
    }
}


