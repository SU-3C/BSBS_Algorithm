using System.Text;

public class BOJ_23252
{
    public static void Main()
    {
        int A, B, C, cnt;
        cnt = int.Parse(Console.ReadLine());

        for (int i = 0; i < cnt; i++)
        {
            string[] input = Console.ReadLine().Split();
            A = int.Parse(input[0]);
            B = int.Parse(input[1]);
            C = int.Parse(input[2]);

            //C를 없앨려면 A가 반드시 하나가 필요하다.
            if (C > A)
            {
                Console.WriteLine("No");
                continue;
            }


            int remain = A - C;
            
            //A의 남은 타일 개수사 홀수면 B을 커버하지 못함
            if (remain % 2 != 0 || A==0)
            {
                Console.WriteLine("No");
                continue;
            }


            //B가 홀수개인데, A가 하나도 없으면 못함
            if (B % 2 == 1)
            {
                Console.WriteLine("No");
            }
            else
            {
                Console.WriteLine("Yes");
            }
        }
    }
}
