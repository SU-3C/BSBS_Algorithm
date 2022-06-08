package Algorithm05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] chessBoard = new String[8];
		int count = 0;
		
		for (int i = 0; i < chessBoard.length; i++) {
			chessBoard[i] = br.readLine();
		}//end for
		
		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) {// 홀수행이면 흰색부터 시작하므로 아래 반복문은 0번째 인덱스부터 시작
				//흰색 값만 필요하므로 2씩 증감
				for (int j = 0; j < chessBoard[i].length(); j += 2) {
					if (chessBoard[i].charAt(j) == 'F')
						count++;
				}//end second for
			} else {//짝수행이면 검은색부터 시작하므로 아래 반복문은 1번째 인덱스부터 시작
				for (int j = 1; j < chessBoard[i].length(); j += 2) {
					if (chessBoard[i].charAt(j) == 'F')
						count++;
				}//end second for
			}//end else if
		}//end first For
		
		System.out.println(count);
	}
}
