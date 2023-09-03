using System.Text;

public class BOJ_23251
{
    public static void Main()
    {
        int cnt = int.Parse(Console.ReadLine());
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < cnt; i++)
        {
            stringBuilder.Append(int.Parse(Console.ReadLine())*23+"\n");
        }
        Console.WriteLine(stringBuilder);
    }
}
