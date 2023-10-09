public class BOJ_2667
{
    static int[] moveX = { -1, 0, 1, 0 };
    static int[] moveY = { 0, -1, 0, 1 };
    public static int line;
    public static List<bool>[] ApartmentList;
    public static List<bool>[] visit;
    public static void Main()
    {
        List<int> answer = new List<int>();
        BOJ_2667 boj2667 = new BOJ_2667();
        boj2667.Initialize();

        for (int i = 0; i < line; i++)
        {
            for (int j = 0; j < line; j++)
            {
                int result = 0;
                if (boj2667.IsPossible(i, j))
                {
                    boj2667.Search(i,j,ref result);
                }
                if (result != 0)
                {
                    answer.Add(result);
                }
            }
        }

        answer.Sort();
        Console.WriteLine(answer.Count);
        for (int i = 0; i < answer.Count; i++)
        {
            Console.WriteLine(answer[i]);
        }
    }

    public void Initialize()
    {
        line=int.Parse(Console.ReadLine());
        ApartmentList = new List<bool>[line];
        visit = new List<bool>[line];

        for (int i = 0; i < line; i++)
        {
            string cmd = Console.ReadLine();
            ApartmentList[i] = new List<bool>();
            visit[i] = new List<bool>();

            for (int j = 0; j < line; j++)
            {
                ApartmentList[i].Add(cmd[j]=='1');
                visit[i].Add(false);
            }
        }
    }

    public void Search(int x,int y,ref int count)
    {
        count++;
        visit[x][y] = true;
        for (int i = 0; i < 4; i++)
        {
            int newX = x + moveX[i];
            int newY = y + moveY[i];

            if (IsPossible(newX, newY))
            {
                Search(newX,newY,ref count);
            }
        }
    }

    public bool IsPossible(int x,int y)
    {
        return x < line && 0 <= x && y < line && 0 <= y && !visit[x][y] && ApartmentList[x][y];
    }
}
