package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2501_minigame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        short A = s.nextShort();
        short B = s.nextShort();
        List<Short> list = new ArrayList<>();
        for (short i = 1; i <= A; i++){
            if (A%i == 0) list.add(i);
        }
        if (list.size() < B) System.out.println(0);
        else System.out.println(list.get(B-1));
    }
}