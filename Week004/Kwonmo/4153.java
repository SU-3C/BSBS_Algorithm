package week4;
import java.util.Scanner;
public class Lectangle {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
     	 while(true) {
     		int x = sc.nextInt();
         	int y = sc.nextInt();
         	int z = sc.nextInt();
        	int r=Math.max(Math.max(x,y),z);
        	
     		if(x == 0 && y == 0 && z == 0) break;//while탈출조건
     		else if(r==x) { //삼각형에서 가장 큰 변이 x,y,z중 뭐인지 모르는 상태라서 각각변이 max값일떄 경우 나눠서 구함
     			if(r*r==y*y+z*z) {
     				System.out.println("right");
     			}
     			else {
     				System.out.println("wrong");
     			}
     		}
     		else if(r==y) {
     			if(r*r==x*x+z*z) {
     				System.out.println("right");
     			}
     			else {
     				System.out.println("wrong");
     			}
     		}
     		else{
     			if(r*r==x*x+y*y) {
     				System.out.println("right");
     			}
     			else {
     				System.out.println("wrong");
     			}
     		}
     	 }
     	 sc.close();
	}

}
