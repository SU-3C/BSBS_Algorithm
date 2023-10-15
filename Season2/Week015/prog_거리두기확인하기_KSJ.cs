/*
 * 거리두기 확인하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 *
 * 문제 풀이 방식
 * - 고정 크기이므로 5X5 사이즈의 고정 2차원 배열 선언
 * - 2차원 배열 안의 데이터는 총 3가지가 필요하므로, bool로는 안될듯..int로 ㄱㄱ
 * - BFS를 통해 문제 해결
 *
 * 1.BFS를 통해 거리가 2이내의 있는 사람을 찾기
 * 2.BFS의 탐색 탈출 범위
 *  2-1.X를 만났을 때
 *  2-2.벽을 만났을 때
 * 탐색 도중 사람을 만나는 순간 탐색 종료,0반환
 */
using System;
using System.Collections.Generic;

 
public class Solution
{
    public const int LineCount = 5;
    public static bool[,] visit;
    private static int[] moveX = { -1, 0, 1, 0 };
    private static int[] moveY = { 0, -1, 0, 1 };
    public static Queue<(int, int, int)> BFSqueue = new Queue<(int, int, int)>();
    public static string[,] Map;
    public int[] solution(string[,] places)
    {
        List<int> answer = new List<int>();
        
        Map = places;
        for (int i = 0; i < 5; i++)
        {
            List<(int, int)> PList = new List<(int, int)>();
            for (int j = 0; j < LineCount; j++)
            {
                for (int k = 0; k < LineCount; k++)
                {
                    if (Map[i, j][k]=='P')
                    {
                        PList.Add((j,k));
                    }
                }
            }
            
            answer.Add(Search_BFS(i,PList));
        }
        return answer.ToArray();
    }

    public int Search_BFS(int line,List<(int, int)> PList)
    {
        int result=1;

        for (int a = 0; a < PList.Count; a++)
        {
            if (result == 0)
            {
                break;
            }
            
            visit = new bool[5, 5];
            BFSqueue.Clear();
            BFSqueue.Enqueue((PList[a].Item1,PList[a].Item2,0));
            
            
            while (BFSqueue.Count > 0)
            {
                ValueTuple<int, int, int> cmd = BFSqueue.Dequeue();
                visit[cmd.Item1, cmd.Item2] = true;

                if (cmd.Item3 > 2)
                {
                    continue;
                }

                if (Map[line, cmd.Item1][cmd.Item2]=='P' && cmd.Item3>0)
                {
                    result = 0;
                    break;
                }
                cmd.Item3++;
                for (int i = 0; i < 4; i++)
                {
                    int newX = cmd.Item1 + moveX[i];
                    int newY = cmd.Item2 + moveY[i];

                    if (IsPossible(line, newX,newY))
                    {
                        BFSqueue.Enqueue((newX, newY, cmd.Item3));
                    }
                }
            }
            
        }
        

        return result;
    }
    
    public bool IsPossible(int line,int x, int y)
{
    return x < LineCount && 0 <= x && y < LineCount && 0 <= y && !visit[x, y] && Map[line, x][y]!='X';
}


}
