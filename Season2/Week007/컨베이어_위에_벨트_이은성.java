import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class RobotOnTheConveyorBelt {

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> duraConveyorBelt = new LinkedList<>();
        LinkedList<Integer> robotLocation = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        String[] conveyorBeltInput = br.readLine().split(" ");
        for (int i = 0; i < N * 2; i++) {
            duraConveyorBelt.add(Integer.parseInt(conveyorBeltInput[i]));
            robotLocation.add(0);
        }

        int zeroCnt = 0;
        int step = 1;
        while (true) {
            zeroCnt = 0;

            // 1. 한 바퀴 돌림
            Integer lastNum = duraConveyorBelt.removeLast();
            duraConveyorBelt.addFirst(lastNum);
            Integer lastRobotNum = robotLocation.removeLast();
            robotLocation.addFirst(lastRobotNum);
            robotLocation.set(N - 1, 0);

            // 2. 로봇 이동
            for (int i = N - 2; i >= 0; i--) {
                if (robotLocation.get(i) == 1 && robotLocation.get(i + 1) == 0 && duraConveyorBelt.get(i + 1) > 0) {
                    robotLocation.set(i + 1, 1);
                    robotLocation.set(i, 0);
                    duraConveyorBelt.set(i + 1, duraConveyorBelt.get(i + 1) - 1);
                }
            }
            robotLocation.set(N - 1, 0); // 로봇을 내리는 위치에 도달하면 내림

            // 3. 올리는 위치에 로봇 올리기
            if (duraConveyorBelt.get(0) > 0 && robotLocation.get(0) == 0) {
                robotLocation.set(0, 1);
                duraConveyorBelt.set(0, duraConveyorBelt.get(0) - 1);
            }

            // 4. 0이 몇 개 있는지 판별
            for (Integer zero : duraConveyorBelt) {
                if (zero == 0) {
                    zeroCnt++;
                }
            }
            if (zeroCnt >= K) break;

            step++;
        }
        System.out.println(step);
    }
}

//Scanner : 2300ms
//BufferedReader :2108ms
