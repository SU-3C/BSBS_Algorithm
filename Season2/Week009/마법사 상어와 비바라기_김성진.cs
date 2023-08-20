public class DDE
{
    public static List<Cloud> Clouds = new List<Cloud>();
    public static List<Command> Commands = new List<Command>();
    public Bucket[,] BucketsMap = null;
    public static int N, M;

    public static void Main()
    {
        DDE dde = new DDE();
        dde.Initialize();
        for (int i = 0; i < Commands.Count; i++)
        {
            int di = Commands[i].d;
            int si = Commands[i].s;
            //1.모든 구름이 di 방향으로 si칸 이동한다.
            dde.RequestMoveCloud(di, si);
            //2.각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
            dde.RequestAddWaterCloud();
            //3.구름이 모두 사라진다.
            dde.RemoveClouds();
            //4.2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 
            dde.WaterCopyBug();
            //5.바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
            dde.AddCloud();
        }

        //M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 구해보자.
        Console.WriteLine(dde.ResultAllWater());
    }

    /// <summary>
    /// 초기화
    /// </summary>
    public void Initialize()
    {
        string[] input1 = Console.ReadLine().Split();
        N = int.Parse(input1[0]);
        M = int.Parse(input1[1]);
        BucketsMap = new Bucket[N, N];
        for (int i = 0; i < N; i++)
        {
            string[] line = Console.ReadLine().Split();
            for (int j = 0; j < N; j++)
            {
                BucketsMap[i, j] = new Bucket(int.Parse(line[j]), false);
            }
        }

        for (int i = 0; i < M; i++)
        {
            string[] line = Console.ReadLine().Split();
            Commands.Add(new Command(int.Parse(line[0]), int.Parse(line[1])));
        }

        Clouds.Add(new Cloud(N - 1, 0));
        Clouds.Add(new Cloud(N - 1, 1));
        Clouds.Add(new Cloud(N - 2, 0));
        Clouds.Add(new Cloud(N - 2, 1));
    }

    /// <summary>
    /// 모든 구름이 di 방향으로 si칸 이동한다.
    /// </summary>
    public void RequestMoveCloud(int di, int si)
    {
        foreach (var cloud in Clouds)
        {
            for (int j = 0; j < si; j++)
            {
                cloud.Move(di);
            }
        }
    }


    public void RequestAddWaterCloud()
    {
        foreach (var cloud in Clouds)
        {
            BucketsMap[cloud.x, cloud.y].water++;
        }
    }

    /// <summary>
    /// 구름이 모두 사라진다.
    /// </summary>
    public void RemoveClouds()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                BucketsMap[i, j].wasCloud = false;
            }
        }

        foreach (var cloud in Clouds)
        {
            BucketsMap[cloud.x, cloud.y].wasCloud = true;
        }

        Clouds.Clear();
    }

    /// <summary>
    /// 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로
    /// 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
    /// 이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
    /// 예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다.
    /// </summary>
    public void WaterCopyBug()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (BucketsMap[i, j].wasCloud)
                {
                    int Succeess = 0;

                    if (i - 1 >= 0 && j - 1 >= 0 && BucketsMap[i - 1, j - 1].water > 0)
                    {
                        Succeess++;
                    }

                    if (i - 1 >= 0 && j + 1 < N && BucketsMap[i - 1, j + 1].water > 0)
                    {
                        Succeess++;
                    }

                    if (i + 1 < N && j - 1 >= 0 && BucketsMap[i + 1, j - 1].water > 0)
                    {
                        Succeess++;
                    }

                    if (i + 1 < N && j + 1 < N && BucketsMap[i + 1, j + 1].water > 0)
                    {
                        Succeess++;
                    }

                    BucketsMap[i, j].water += Succeess;
                }
            }
        }
    }

    public void AddCloud()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (!BucketsMap[i, j].wasCloud && BucketsMap[i, j].water>=2)
                {
                    Clouds.Add(new Cloud(i,j));
                    BucketsMap[i, j].water -= 2;
                }
            }
        }
    }

    /// <summary>
    /// 바구니에 들어있는 물의 양의 합을 출력한다.
    /// </summary>
    public int ResultAllWater()
    {
        int result = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                result += BucketsMap[i, j].water;
            }
        }

        return result;
    }
    
    public class Command
    {
        public int d;
        public int s;

        public Command(int d, int s)
        {
            this.d = d;
            this.s = s;
        }
    }

    public class Bucket
    {
        public int water;
        public bool wasCloud;

        public Bucket(int water, bool wasCloud)
        {
            this.water = water;
            this.wasCloud = wasCloud;
        }
    }

    public class Cloud
    {
        public int x;
        public int y;

        public Cloud(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public void Move(int type)
        {
            switch (type)
            {
                case 1:
                    y--;
                    break;
                case 2:
                    x--;
                    y--;
                    break;
                case 3:
                    x--;
                    break;
                case 4:
                    x--;
                    y++;
                    break;
                case 5:
                    y++;
                    break;
                case 6:
                    y++;
                    x++;
                    break;
                case 7:
                    x++;
                    break;
                case 8:
                    x++;
                    y--;
                    break;
            }

            if (x < 0)
                x = N - 1;
            if (x >= N)
                x = 0;
            if (y < 0)
                y = N - 1;
            if (y >= N)
                y = 0;
        }
    }
}
