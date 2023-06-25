package Algorithm;

import java.util.Scanner;

public class Main_2525{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int min = scanner.nextInt();
        scanner.nextLine();
        int cookTime = scanner.nextInt();
        
        if(min+cookTime>=60){
        	//60분이 넘어갈 경우
            //조시시간과 입력한 시간의 분 값을 더한 값이 몇 시간인지 담는 변수
            int hCount = (min+cookTime)/60;
            //시간에 해당하는 시간만큼 더해줌
            hour +=hCount;
            //조리가 끝나는 분을 저장
            min = (min+cookTime)-hCount*60;
            
            //시간이 24시와 같거나 넘어갈 경우
            if(hour>=24){
                hour-=24;
            }
        }else {
        	//조리시간과 현재시간의 합이 60분 미만일 경우
        	min+=cookTime;
        }
        System.out.print(hour+" "+min);
    }
}