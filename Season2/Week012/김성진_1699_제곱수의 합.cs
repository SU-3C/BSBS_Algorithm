public class BOJ_1699
{
    private static int[] dp = new int[100001];
    public static void Main()
    {
        for (int i = 0; i < 100001; i++)
        {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        Console.WriteLine(Power(int.Parse(Console.ReadLine())));
    }

    public static int Power(int n)
    {
        int number = n;

        if (dp[number] > 0)
        {
            return dp[number];
        }
        
        List<int> list = new List<int>();

        int startnum = 1;
        while (true)
        {
            if (number - Math.Pow(startnum, 2.0) < 0)
            {
                break;
            }
            else
            {
                int mynum = number - (int)Math.Pow(startnum, 2.0);
                if (dp[mynum] == -1)
                {
                    dp[mynum] = Power(mynum);
                }
                list.Add(1+dp[mynum]);
                startnum++;
            }
        }
        list.Sort();
        dp[number] = list[0];
        return dp[number];
    }
}
