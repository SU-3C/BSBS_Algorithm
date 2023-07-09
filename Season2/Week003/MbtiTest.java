import java.util.HashMap;
import java.util.Map;

public class MbtiTest {
    public static void main(String[] args) {
        String[] servey = new String[]{"AN", "CF", "MJ", "RT", "NA"};
        int[] choices  = new int[]{5, 3, 2, 7, 5};
        MbtiTest mbtiTest = new MbtiTest();
        String solution = mbtiTest.solution(servey, choices);
        System.out.println("solution = " + solution);
    }

    public String solution(String[] survey, int[] choices) {
        String SignitureType = "RTCFJMAN";
        Map<String,Integer> personalityType = new HashMap<>();
        personalityTypeAdd(SignitureType, personalityType);

      //동의,비동의 비교하는 방법
        for (int i = 0; i <choices.length ; i++) {
            String[] splitType = survey[i].split("");
            if(choices[i]>4){
                Integer value = personalityType.get(splitType[1]);
             value += Math.abs(choices[i]-4);
             personalityType.put(splitType[1],value);
            } else {
                Integer value = personalityType.get(splitType[0]);
                value += Math.abs(choices[i]-4);
                personalityType.put(splitType[0],value);
            }
        }
      
      //문자 문자 비교하는 메서드
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < SignitureType.length(); i+=2) {
            if(personalityType.get(String.valueOf(SignitureType.charAt(i)))>personalityType.get(String.valueOf(SignitureType.charAt(i+1)))){
                answer.append(SignitureType.charAt(i));
            }else if(personalityType.get(String.valueOf(SignitureType.charAt(i))) == personalityType.get(String.valueOf(SignitureType.charAt(i+1)))) {
                if(SignitureType.charAt(i)<SignitureType.charAt(i+1)){
                    answer.append(SignitureType.charAt(i));
                }else {
                    answer.append(SignitureType.charAt(i+1));
                }
            } else {
                answer.append(SignitureType.charAt(i+1));
            }
        }
        return answer.toString();
    }

  //Map에 성격유형 담는 메서드
    private static void personalityTypeAdd(String type, Map<String, Integer> personalityType) {
        for (int i = 0; i < type.length(); i++) {
            personalityType.put(String.valueOf(type.charAt(i)),0);
        }
    }

}
