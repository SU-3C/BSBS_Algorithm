using System;
using System.Linq;
using System.Collections.Generic;

public class AnswerResult
{
    public int emoticonplusCount;
    public int AllBuyMoney;

    public AnswerResult(int emoticonplusCount, int allBuyMoney)
    {
        this.emoticonplusCount = emoticonplusCount;
        AllBuyMoney = allBuyMoney;
    }
}
public class Solution
{

    public List<AnswerResult> Results=new List<AnswerResult>();

    public int[] solution(int[,] users, int[] emoticons) {
      
        
        int[] values = { 10, 20, 30, 40 };
        int arrayLength = emoticons.Length;

        List<int[]> combinations = GenerateCombinations(values, arrayLength);

        foreach (var combination in combinations)
        {
            int emoticonplusCount=0, AllBuyMoney=0;
            int result = 0;
            for (int i = 0; i < users.Length/2; i++)
            {
                result=CalculateEmoticon(users[i,0],users[i,1],emoticons,combination);
                
                if (result == -1)
                {
                    emoticonplusCount++;
                }
                else
                {
                    AllBuyMoney += result;
                }
            }
            Results.Add(new AnswerResult(emoticonplusCount,AllBuyMoney));
        }
        
        
        var sortedResults = Results.OrderByDescending(result => result.emoticonplusCount)
            .ThenByDescending(result => result.AllBuyMoney).First();
        
        int[] answer = new int[] {sortedResults.emoticonplusCount,sortedResults.AllBuyMoney};
        return answer;
    }

    static int ApplyDiscount(int originalPrice, int discountRate)
    {
        double discountFactor = 1.0 - (discountRate / 100.0);
        double discountedPrice = originalPrice * discountFactor;
        return (int)Math.Round(discountedPrice);
    }
    
    /// <summary>
    /// 이모티콘 플러스 서비스 가입 여부와 이모티콘 판매 가격을 구하는 함수
    /// return -1 => 이모티콘플러스 가입
    /// </summary>
    /// <param name="targetPercent"></param>
    /// <param name="money"></param>
    /// <param name="disCountPrice"></param>
    public int CalculateEmoticon(int targetPercent,int money,int[]emotioncons,int[] combination)
    {
        int PayPrice = 0;
        for (int i = 0; i < emotioncons.Length; i++)
        {
            if (targetPercent <= combination[i])
            {
                PayPrice += ApplyDiscount(emotioncons[i], combination[i]);
            }
            if (PayPrice >= money)
            {
                return -1;
            }
        }

        return PayPrice;
    }
    static List<int[]> GenerateCombinations(int[] values, int arrayLength)
    {
        List<int[]> combinations = new List<int[]>();
        int[] currentCombination = new int[arrayLength];

        GenerateCombinationsRecursive(values, currentCombination, 0, combinations);

        return combinations;
    }

    static void GenerateCombinationsRecursive(int[] values, int[] currentCombination, int currentIndex, List<int[]> combinations)
    {
        if (currentIndex == currentCombination.Length)
        {
            combinations.Add(currentCombination.ToArray());
            return;
        }

        for (int i = 0; i < values.Length; i++)
        {
            currentCombination[currentIndex] = values[i];
            GenerateCombinationsRecursive(values, currentCombination, currentIndex + 1, combinations);
        }
    }
    
}

class Program
{
    static void Main(string[] args)
    {
        Solution solution = new Solution();
        int[] answer=(solution.solution(new int[,]{{40,2900},{23,10000},{11,5200},{5,5900},{40,3100},{27,9200},{32,6900} }, new[] { 1300,1500,1600,4900 }));
        Console.WriteLine(answer[0]);
        Console.WriteLine(answer[1]);
    }

}
