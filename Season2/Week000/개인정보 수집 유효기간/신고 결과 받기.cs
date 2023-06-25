using System.Collections.Generic;
using System.Linq;

public class Solution
{
    Dictionary<string, int> DeclarationDictionary = new Dictionary<string, int>();
    Dictionary<string, int> resultDictionary = new Dictionary<string, int>();
    Dictionary<string, List<string>> reverseDeclarationlDic = new Dictionary<string, List<string>>();

    public int[] solution(string[] id_list, string[] report, int k)
    {
        report=report.Distinct().ToArray();

        for (int i = 0; i < id_list.Length; i++)
        {
            DeclarationDictionary.Add(id_list[i],0);
            reverseDeclarationlDic.Add(id_list[i],new List<string>());
            resultDictionary.Add(id_list[i],0);
        }
        
        foreach (var s in report)
        {
            string[] split = s.Split();
            DeclarationDictionary[split[1]]++;
            if(!reverseDeclarationlDic[split[0]].Contains(split[1]))
                reverseDeclarationlDic[split[0]].Add(split[1]);
        }
        List<string> keysAboveK = new List<string>();

        foreach (var pair in DeclarationDictionary)
        {
            if (pair.Value >= k)
            {
                keysAboveK.Add(pair.Key);
            }
        }
        
        foreach (var pair in reverseDeclarationlDic)
        {
            for (int i = 0; i < pair.Value.Count; i++)
            {
                if (keysAboveK.Contains(pair.Value[i]))
                {
                    resultDictionary[pair.Key]++;
                }
            }
        }

        List<int> answerlist = new List<int>();
        for (int i = 0; i < id_list.Length; i++)
        {
            answerlist.Add(resultDictionary[id_list[i]]);
        }
        int[] answer = new int[] {};
        answer = answerlist.ToArray();
        return answer;
    }
}
public class DDE
{
    public static void Main(string[] Args)
    {
        Solution solution = new Solution();
        string[] id_list = new string[] { "muzi", "frodo", "apeach", "neo" };
        string[] report	 = new string[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int[] answer = solution.solution(id_list, report, 2);
        for (int i = 0; i < answer.Length ; i++)
        {
            Console.WriteLine(answer[i]);
        }
       
    }
}