/*
 * 게임 맵 최단거리 문제 풀이
 * - BFS를 통해 구현 예정
 * DFS가 아닌 BFS를 사용하는 이유
 * 1.DFS를 통해 최단 경로 알고리즘을 구현한다면, 최단 경로가 아닌 모든 길을
 * 탐색해봐야한다는 단점이 있음
 * 2.BFS는 도착지점에 도착하는 순간 종료시켜버리면 됨
 *
 * 풀이 예상
 * - 0,0의 지점부터 BFS탐색을 시작함
 * - 큐에 한번 삽입할 때마다 탐색 횟수 1증가시킴
 *  - (이는 도착점까지의 거리가 됨)
 * - 탐색 도충 도착지점의 좌표를 만나면 정지 후, 현재 탐색 횟수를 출력
 * - 더 이상 탐색할 곳이 없다면, -1 출력
 */

using System;
using System.Collections.Generic;

class Solution
{
    private static int[,] map;
    private static bool[,] visit;
    private static int[] moveX = { -1, 0, 1, 0 };
    private static int[] moveY = { 0, -1, 0, 1 };
    private static int row, col;
    static Queue<(int, int, int)> BFSqueue = new Queue<(int, int, int)>();

    public int solution(int[,] maps)
    {
        map = maps;
        row = map.GetLength(0);
        col = map.GetLength(1);
        visit = new bool[row, col];

        return Search_BFS(0, 0);
    }

    public bool IsPossible(int x, int y)
    {
        return x < row && 0 <= x && y < col && 0 <= y && !visit[x, y] && map[x, y] == 1;
    }

    public int Search_BFS(int x, int y)
    {
        BFSqueue.Enqueue((x, y, 0));
        while (BFSqueue.Count > 0)
        {
            ValueTuple<int, int, int> cmd = BFSqueue.Dequeue();
            if (cmd.Item1 == row - 1 && cmd.Item2 == col - 1)
            {
                return cmd.Item3 + 1;
            }

            cmd.Item3++;


            for (int i = 0; i < 4; i++)
            {
                int newX = cmd.Item1 + moveX[i];
                int newY = cmd.Item2 + moveY[i];

                if (IsPossible(newX, newY))
                {
                    visit[newX, newY] = true;
                    BFSqueue.Enqueue((newX, newY, cmd.Item3));
                }
            }
        }

        return -1;
    }

}
