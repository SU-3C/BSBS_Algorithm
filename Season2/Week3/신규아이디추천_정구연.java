package programmers;

import java.util.Locale;

public class Programmers {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution("z-+.^."));
    }
}


class Solution {
    public String solution(String new_id) {
        new_id = lowerCase(new_id);
        new_id = replaceExceptChar(new_id);
        new_id = replaceContinueEndPoint(new_id);
        new_id = replaceStartEndWithEndPoint(new_id);
        new_id = checkLengthZero(new_id);
        new_id = checkLengthMax(new_id);
        new_id = checkLengthMin(new_id);
        return new_id;
    }

    public String lowerCase(String id){
        return id.toLowerCase(Locale.ENGLISH);
    }
    public String replaceExceptChar(String id){
        String regex = "[^\\w-_.]";
        return id.replaceAll(regex, "");
    }
    public String replaceContinueEndPoint(String id){
        String regex = "[.]+";
        return id.replaceAll(regex, ".");
    }
    public String replaceStartEndWithEndPoint(String id){
        String regexStart = "^\\.";
        id = id.replaceAll(regexStart, "");
        String regexEnd = "\\.$";
        id = id.replaceAll(regexEnd, "");
        return id; //
    }
    public String checkLengthZero(String id){
        return (id.length() == 0)?"a":id;
    }
    public String checkLengthMax(String id){
        id = (id.length() > 15)?id.substring(0, 15):id;
        return replaceStartEndWithEndPoint(id);
    }
    public String checkLengthMin(String id){
        String lastChar = id.substring(id.length() - 1).repeat(2);
        return (id.length() < 3)?id.concat(lastChar).substring(0, 3):id;
    }
}
