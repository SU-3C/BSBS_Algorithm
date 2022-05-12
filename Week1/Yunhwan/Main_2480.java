package Algorithm;

import java.util.Scanner;
public class Main_2480{
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//상금
		int price = 0;
		// 주사위 값을 입력 받음
		int[] inputDice = new int[3];
		for (int i = 0; i < inputDice.length; i++) {
			inputDice[i] = scanner.nextInt();
		}
		//주사위 값이 전부 같을 때
		if (inputDice[0] == inputDice[1] && inputDice[0] == inputDice[2]) {
			price = 10000 + 1000 * inputDice[0];
		  //주사위눈 금이 2개가 같을 때
		} else if (inputDice[0] == inputDice[1] || inputDice[0] == inputDice[2]) {
			price = 1000 + 100 * inputDice[0];
		} else if (inputDice[1] == inputDice[2]) {
			price = 1000 + 100 * inputDice[1];
		  //주사위 값이 다 다를 때
		} else {
			int bigNum = inputDice[0] > inputDice[1] ? inputDice[0] : inputDice[1];
			bigNum = bigNum > inputDice[2] ? bigNum : inputDice[2];
			price = 100 * bigNum;
		}
		System.out.println(price);
	}
}