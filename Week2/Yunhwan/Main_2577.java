package Algorithm02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2577 {
	public static void main(String[] args)throws IOException{//버퍼리더를 쓰기위한 예외던지기
        //버퍼리더를 사용하기 위한 예외처리 블록
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //byte의 표현범위는 -128 ~ 127
            byte[] countNum = new byte[10];
            //short의 표현범위는 -32,768 ~ 32,767 둘다 정수형
            short[] inputNum = new short[3];
            int sum = 0;
            
            //3개의 값을 입력받기 위한 반복문
            for(int i=0; i<inputNum.length; i++){
                inputNum[i] = Short.parseShort(br.readLine());
            }
            //입력받은 값을 곱한 값 저장 
            sum = inputNum[0]*inputNum[1]*inputNum[2];
            //곱해준 sum을 문자열로 변환하여 그 길이만큼 반복
            for(int i=0; i<Integer.toString(sum).length(); i++){
            	//문자열로 바꿔준 sum값을 charAt으로 해당 자리의 수 값을 인덱스로 넣어주어
            	//해당 인덱스 배열의 값을 1증가시켜줌
            	countNum[Integer.toString(sum).charAt(i)-'0']+=1;
            }
            //갯수를 새기 위한 배열을 출력 인덱스값이 해당 숫자고 해당 인덱스 값이 존재 갯수
            for(int i =0; i<countNum.length;i++){
                System.out.println(countNum[i]+0);
            }
            //입력버퍼를 닫아줌
            br.close();
        }catch(IOException e){}
    }
}
