package week9;

import java.io.*;

public class Main_9372 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] m;
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            m=br.readLine().split(" ");
            for(int j=0;j<Integer.parseInt(m[1]);j++){
                br.readLine();
//                if (!flag){
//                    for(int k=0;k<2;k++){
//                        if(t.add(Integer.parseInt(M[k])))
//                            flag2=true;
//                    }
//                    if(flag2)
//                        cnt++;
//                    if (t.size()==Integer.parseInt(m[0])){
//                        bw.write((cnt)+"\n");
//                        flag=true;
//                        t.clear();
//                    }
//                    flag2=false;
//                }
            }
//            cnt=0;
//            flag=false;
            bw.write(Integer.parseInt(m[0])-1+"\n");
        }
        bw.flush();
    }
}


//for(int j=0;j<Integer.parseInt(m[1]);j++){
//        M=br.readLine().split(" ");
//        if (!flag){
//        for(int k=0;k<2;k++){
//        try { v.add(Integer.parseInt(M[k])); } catch (Exception e){ }
//        if (v.size()==Integer.parseInt(m[0])){
//        bw.write((j+1)+"\n");
//        flag=true;
//        v.clear();
//        break;
//        }
//        }
//        }
//        }