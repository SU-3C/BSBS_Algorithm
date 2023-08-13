using System;
using System.Collections.Generic;

class RoomCell
{
    public bool isWall;
    public bool isClean;

    public RoomCell(bool isWall, bool isClean)
    {
        this.isWall = isWall;
        this.isClean = isClean;
    }
}

public class Solution
{
    private List<List<RoomCell>> Room = new List<List<RoomCell>>();
    public static Dictionary<int, int[]> rotationTarget = new Dictionary<int, int[]>();
    public static int N, M, r, c, d, CleanCount;

    public static void Main()
    {
        Solution solution = new Solution();

        solution.Initialize();

        while (true)
        {
            //1번
            solution.CleanPosition();
            
            
            //2번
            int result= solution.MoveRobotCleaner();
            if (result == 0)
            {
                break;
            }
            else if (result == 1)
            {
                continue;   
            }
            else
            {
                //3번
                solution.RoatateRobotCleaner();
            }
            
        }

        Console.WriteLine(CleanCount);

    }

    //0.풀이에 필요한 값 초기화
    public void Initialize()
    {
        string[] input1 = Console.ReadLine().Split();
        N = int.Parse(input1[0]);
        M = int.Parse(input1[1]);

        string[] input2 = Console.ReadLine().Split();
        r = int.Parse(input2[0]);
        c = int.Parse(input2[1]);
        d = int.Parse(input2[2]);

        rotationTarget.Add(0, new int[] { -1, 0 });
        rotationTarget.Add(1, new int[] { 0, 1 });
        rotationTarget.Add(2, new int[] { 1, 0 });
        rotationTarget.Add(3, new int[] { 0, -1 });

        for (int i = 0; i < N; i++)
        {
            Room.Add(new List<RoomCell>());
            string[] RoomCellInput = Console.ReadLine().Split();
            for (int j = 0; j < M; j++)
            {
                Room[i].Add(new RoomCell(int.Parse(RoomCellInput[j]) == 1, false));
            }
        }
    }

    //1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
    public void CleanPosition()
    {
        if (!Room[r][c].isClean)
        {
            Room[r][c].isClean = true;
            CleanCount++;
        }
    }

    //2.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
    //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
    //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
    public int MoveRobotCleaner()
    {
        if (!CheckDirtyPalce())
        {
            int x, y;
            x = isCanGoBack()[0];
            y = isCanGoBack()[1];
            if (x==-1)
            {
                //작동을 멈춘다
                return 0;
            }
            else
            {
                r = x;
                c = y;
                //1번으로 돌아간다
                return 1;
            }
        }
        else
        {
            //청소되지 않은 빈 칸이 있다
            return 2;
        }
    }

    //3.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
    //3-1.반시계 방향으로 90도회전한다.
    //3-2.바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
    //3-3.1번으로 돌아간다.
        
    public void RoatateRobotCleaner()
    {
        d--;
        if (d < 0)
        {
            d = 3;
        }
        int x, y;
        x = isCanGoAhead()[0];
        y = isCanGoAhead()[1];

        if (x != -1)
        {
            r = x;
            c = y;
        }
    }
    
    //로봇청소기 한 칸 후진 가능?
    public int[] isCanGoBack()
    {
        int backrotation = (d + 2) %4;
        int x = r + rotationTarget[backrotation][0];
        int y = c + rotationTarget[backrotation][1];

        if (x < 0 || x >= N || y < 0 || y >= M)
        {
            return new int[]{-1,0};
        }

        if (Room[x][y].isWall)
        {
            return new int[]{-1,0};
        }
        return new int[]{x,y};
        
    }

    //로봇청소기 한 칸 전진 가능?
    public int[] isCanGoAhead()
    {
        int x = r + rotationTarget[d][0];
        int y = c + rotationTarget[d][1];

        if (x < 0 || x >= N || y < 0 || y >= M)
        {
            return new int[]{-1,0};
        }

        if (Room[x][y].isWall)
        {
            return new int[]{-1,0};
        }
        
        if(Room[x][y].isClean)
        {
            return new int[]{-1,0};
        }

        return new int[]{x,y};
    }

    //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는가?
    public bool CheckDirtyPalce()
    {
        for (int i = 0; i < 4; i++)
        {
            int x, y;
            x = r + rotationTarget[i][0];
            y = c + rotationTarget[i][1];

            if (x < 0 || x >= N || y < 0 || y >= M)
            {
                continue;
            }

            if (!Room[x][y].isWall && !Room[x][y].isClean)
            {
                return true;
            }
        }

        return false;
    }
}
