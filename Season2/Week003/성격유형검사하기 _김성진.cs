using System;
using System.Collections.Generic;

public class Solution
{
    private Dictionary<char, int> PersonalType;
    public string solution(string[] survey, int[] choices)
    {

        Initalize("RTCFJMAN");
        
        for (int i = 0; i < survey.Length; i++)
        {
            AddScore(survey[i], choices[i]);
        }
        
        string answer = PrintResult();
        return answer;
    }

    string ResultPrint(char A,char B)
    {
        if (PersonalType[A] > PersonalType[B])
        {
            return A.ToString();
        }
        else if (PersonalType[A] < PersonalType[B])
        {
            return B.ToString();
        }
        else
        {
            if (A < B)
            {
                return A.ToString();
            }
            else
            {
                return B.ToString();
            }
        }
    }
    string PrintResult()
    {
        string result = "";


        result += ResultPrint('R','T');
        result += ResultPrint('C','F');
        result += ResultPrint('J','M');
        result += ResultPrint('A','N');
        return result;
    }
    void AddScore(string surveyInput,int choice)
    {
        if (choice > 4)
        {
            PersonalType[surveyInput[1]] += Math.Abs(4 - choice);
        }
        else if (choice<4)
        {
            PersonalType[surveyInput[0]] += Math.Abs(4 - choice);
        }
    }
    
    void Initalize(string s)
    {
        PersonalType = new Dictionary<char, int>();
        foreach (var ch in s)
        {
            PersonalType.Add(ch,0);
        }
    }
}
