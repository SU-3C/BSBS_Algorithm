package Algorithm02;
import java.util.Scanner;
public class Main_10818{
	public static void main(String[] args) {
		
    Scanner scanner = new Scanner(System.in);
    
    int inputN = scanner.nextInt();
    int[] inputArray = new int[inputN];
    int Max = -1000000;
    int Min = 1000000;
    
    for(int i = 0; i<inputArray.length; i++){
        inputArray[i] = scanner.nextInt();
        if(inputArray[i]>=Max)Max = inputArray[i];
        if(inputArray[i]<=Min)Min = inputArray[i];
    }
    System.out.println(Min+" "+Max);
	}
}