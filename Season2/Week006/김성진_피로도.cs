
using System;
using System.Collections.Generic;

public class Solution
{
    public int[,] Maindungeons;
    public int MainK;
    public int result = 0;
    public int solution(int k, int[,] dungeons)
    {
        Maindungeons = dungeons;
        MainK = k;
        SequentialPermutationMain(dungeons.GetLength(0));
        return result;
    }
    public void Permute(int[] nums, int start, int end)
    {
        if (start == end)
        {
            int tempresult = CalculateResult(MainK,nums);
            if (tempresult > result)
            {
                result = tempresult;
            }
            return;
        }

        for (int i = start; i < end; i++)
        {
            Swap(nums, start, i);
            Permute(nums, start + 1, end);
            Swap(nums, start, i); // Revert the swap
        }
    }

    public void Swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void SequentialPermutationMain(int n)
    {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = i;
        }

        Permute(nums, 0, n);
    }


    public int CalculateResult(int startFatigue,int[]DungeonSequence)
    {
        int result = 0;
        int Fatigue = startFatigue;

        foreach (var now in DungeonSequence)
        {
            int currentMinFatigue = Maindungeons[now,0];
            int currentFatigue = Maindungeons[now,1];
            if (Fatigue >= currentMinFatigue)
            {
                Fatigue -= currentFatigue;
                if (Fatigue <= 0)
                {
                    break;
                }

                result++;
            }
            else
            {
                break;
            }
        }
        return result;
    }
}


public class Program
{
    public static void Main()
    {
        Solution solution = new Solution();
        int k = 80;
        int[,] ints = new int[3,3];
        ints[0, 0] = 80;
        ints[0, 1] = 20;
        ints[1, 0] = 50;
        ints[1, 1] = 40;
        ints[2, 0] = 30;
        ints[2, 1] = 10;
        Console.WriteLine(solution.solution(k,ints));
    }
}