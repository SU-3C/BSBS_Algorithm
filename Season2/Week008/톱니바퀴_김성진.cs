using System;
using System.Collections.Generic;

#region Deque

class Deque<T>
{
    private LinkedList<T> items = new LinkedList<T>();

    public void EnqueueFront(T item)
    {
        items.AddFirst(item);
    }

    public void EnqueueBack(T item)
    {
        items.AddLast(item);
    }

    public T DequeueFront()
    {
        if (items.Count == 0)
            throw new InvalidOperationException("Deque is empty.");

        T item = items.First.Value;
        items.RemoveFirst();
        return item;
    }

    public T DequeueBack()
    {
        if (items.Count == 0)
            throw new InvalidOperationException("Deque is empty.");

        T item = items.Last.Value;
        items.RemoveLast();
        return item;
    }

    public int Count
    {
        get { return items.Count; }
    }

    public bool ValueIs(int count)
    {
        LinkedListNode<T> item = items.First;
        for (int i = 0; i < count; i++)
        {
            item = item.Next;
        }

        return item.Value.Equals(true);
    }
}

#endregion

public class Solution
{
    private static Deque<bool>[] Gears = new Deque<bool>[4];

    public static void Main()
    {
        Solution solution = new Solution();
        solution.Initialize();

        int rotateCount = int.Parse(Console.ReadLine());

        for (int i = 0; i < rotateCount; i++)
        {
            int x, y;
            string[] input = Console.ReadLine().Split();
            x = int.Parse(input[0]);
            y = int.Parse(input[1]);
            List<int> directList=solution.CalculateDirectionGear(x-1, y == 1);
            for (int j = 0; j < directList.Count; j++)
            {
                if (directList[j] > -1)
                {
                    solution.RotateGear(j,directList[j]==1);
                }
            }
        }

        Console.WriteLine(solution.CalcaulateScore());
    }

    public void Initialize()
    {
        for (int i = 0; i < 4; i++)
        {
            Gears[i] = new Deque<bool>();
            string s = Console.ReadLine();
            for (int j = 0; j < 8; j++)
            {
                Gears[i].EnqueueBack(s[j].Equals('1'));
            }
        }
    }

    public void RotateGear(int gearNumber, bool rotateDir)
    {
        if (rotateDir)
        {
            Gears[gearNumber].EnqueueFront(Gears[gearNumber].DequeueBack());
        }
        else
        {
            Gears[gearNumber].EnqueueBack(Gears[gearNumber].DequeueFront());
        }
    }


    public int Convert(bool dir)
    {
        if (dir) return 1;
        else return 0;
    }

    public List<int> CalculateDirectionGear(int gearNumber, bool rotateDir)
    {
        int[] movelist = new int[4]{-1,-1,-1,-1};
        movelist[gearNumber] = Convert(rotateDir);
        int currentrgearNumber;
        bool currentrotateDir;
        
         currentrgearNumber = gearNumber;
         currentrotateDir = rotateDir;

        while (true)
        {
            if (currentrgearNumber == 3) break;
            currentrgearNumber++;
            if (Gears[currentrgearNumber-1].ValueIs(2) != Gears[currentrgearNumber].ValueIs(6))
            {
                currentrotateDir = !currentrotateDir;
                movelist[currentrgearNumber] = Convert(currentrotateDir);
            }
            else
            {
                movelist[currentrgearNumber] = -1;
                break;
            }
        }
        
         currentrgearNumber = gearNumber;
         currentrotateDir = rotateDir;
        while (true)
        {
            if (currentrgearNumber == 0) break;
            currentrgearNumber--;
            if (Gears[currentrgearNumber].ValueIs(2) != Gears[currentrgearNumber+1].ValueIs(6))
            {
                currentrotateDir = !currentrotateDir;
                movelist[currentrgearNumber] = Convert(currentrotateDir);
            }
            else
            {
                movelist[currentrgearNumber] = -1;
                break;
            }
        }

        return movelist.ToList();
    }

    public int CalcaulateScore()
    {
        int score = 0;
        if (Gears[0].DequeueFront())
            score += 1;
        if (Gears[1].DequeueFront())
            score += 2;
        if (Gears[2].DequeueFront())
            score += 4;
        if (Gears[3].DequeueFront())
            score += 8;

        return score;
    }
}
