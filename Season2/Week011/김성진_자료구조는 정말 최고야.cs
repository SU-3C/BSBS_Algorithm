using System;

public class BOJ_23252
{
    public static int M, N;
    public static Dictionary<int,Stack<int>> Stacks = new Dictionary<int,Stack<int>>();
    public static void Main()
    {
        int[] input = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
        M = input[0];
        N = input[1];

        for (int i = 0; i < N; i++)
        {
            int k = int.Parse(Console.ReadLine());
            int[] inputnum = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
           Stacks.Add(inputnum[inputnum.Length-1],new Stack<int>());
            for (int j = 0; j < k; j++)
            {
                Stacks[inputnum[inputnum.Length-1]].Push(inputnum[j]);
            }

            Stacks[inputnum[inputnum.Length - 1]].Pop();
        }

        int now = 0;
        bool continueWhileLoop = false;

        while (true)
        {
            now++;

            if (Stacks.ContainsKey(now))
            {
                if (Stacks[now].Count > 0)
                {
                    int peek = Stacks[now].Peek();
                    Stacks[now].Pop();
                    Stacks.Add(peek,Stacks[now]);  
                }
                if (now == M)
                {
                    Console.WriteLine("Yes");
                    return;
                }
            }
            else
            {
                Console.WriteLine("No");
                return;
            }
        }
    }
}
