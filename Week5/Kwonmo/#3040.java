package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindDwarf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int [] dwarf=new int[9];
		int sum=0;
		int fuckingDwarf1=0,fuckingDwarf2=0;
		
		for(int i=0;i<9;i++) {
			dwarf[i]=Integer.parseInt(br.readLine());
			sum+=dwarf[i];
		}
		
		for(int i=0;i<dwarf.length-1;i++) {
			//9개의 배열중 2개의 배열을 골라야 하기에 length-1
			for(int j=1;j<dwarf.length;j++) {
				//이건 1부터 length까지
				if(sum-(dwarf[i]+dwarf[j])==100 && i!=j) {
					fuckingDwarf1=i;
					fuckingDwarf2=j;
					//퍼킹난쟁이1 , 2 의 인덱스 번호를 추출한다.
					break;
					//혹시 추출된 배열인덱스를 제거하고 다시 배열을 만드는 방법은???
				}
			}
		}
		for(int i=0;i<dwarf.length;i++) {
			if(i==fuckingDwarf1 || i ==fuckingDwarf2) {
				continue;
				//가짜 난쟁이의 인덱스를 접하면 i++하고 다음 반복으로 진행
			}
			System.out.println(dwarf[i]);//찐 난쟁이들 출력
		}
	}

}
