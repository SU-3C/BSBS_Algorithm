package week7;

import java.io.*;

// 쇠막대기 레이저로 자르기 문제
public class Main_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String in=br.readLine();
        int cnt=0, pipecnt=0;
        for (int i=0;i<in.length();i++){
            char c=in.charAt(i);
            if (c=='('){
                pipecnt++;
            } else {
                pipecnt--;
                if (sb.substring(sb.length()-1).equals("(")){
                    cnt+=pipecnt;
                } else {
                    cnt++;
                }
            }
            sb.append(c);
        }
        bw.write(cnt+"");
        bw.flush();
    }
}

//bw.write(i + " -> sb : " + sb.toString() + " , pipecnt : " + pipecnt + " , cnt : " + cnt + "\n");


//    String str=sb.toString();
//            if (c=='('){
//                pipecnt++;
//                if (str.equals("(")){
//                    s.push(str);
//                    continue;
//                }
//                sb.append(c);
//            } else {
//                if (str.equals("(")){
//                    str = sb.append(c).toString();
//                    s.push(str);
//                    sb.setLength(0);
//                    pipecnt--;
//                    cnt+=pipecnt;
//                } else {
//                    pipecnt--;
//                    cnt++;
//                    try{
//                        s.remove(s.lastIndexOf("("));
//                    } catch (Exception e){
//                        continue;
//                    }
//                }
//            }


//            if (c=='(')
//                s.push(c);
//            else {
//                if (s.peek()=='('){
//                    for(char j:s) {
//                        if(j=='(') cnt++;
//                    }
//                } else {
//                    cnt++;
//                    s.remove(s. lastIndexOf('('));
//                }
//            }