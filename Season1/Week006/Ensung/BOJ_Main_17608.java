import java.util.Scanner;

public class BOJ_Main_17608 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<num.length; i++)
            num[i] = sc.nextInt();

        int count=1;
        int max = num[num.length-1];
        //배열중에 최대값

        for(int i= num.length-2; i>=0; i--){
            if(num[i]>max){
                count++;
                max=num[i];
                //맨뒤에 값보다 커야 막대가 보이기때문에 카운트올린다.
            }
        }
        sc.close();
        System.out.println(count);
    }
}
