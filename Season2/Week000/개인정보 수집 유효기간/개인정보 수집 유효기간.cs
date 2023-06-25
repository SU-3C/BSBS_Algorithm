namespace ConsoleApp1;

using System.Collections.Generic;

public class Solution
{
    //오늘 날찌
    public static Date Today;
    //약관 종류, 개월
    private Dictionary<string, int> termsDic=new Dictionary<string, int>();
    public int[] solution(string today, string[] terms, string[] privacies) {
        int[] answer = new int[] {};

        List<int> AnswerList = new List<int>();
        Today = new Date(today);

        //term입력 받음
        foreach (var term in terms)
        {
            string[] termSplit = term.Split();
            termsDic.Add(termSplit[0],int.Parse(termSplit[1]));
        }

        //privacies 입력 받음
        for (int i = 0; i < privacies.Length; i++)
        {
            string[] privaciesSplit = privacies[i].Split();
            Date date = new Date(privaciesSplit[0]);
            date.AfterDate(termsDic[privaciesSplit[1]]);

            if(isExpired(date)) AnswerList.Add(i+1);
        }

        answer = AnswerList.ToArray();
        return answer;
    }


    //기만 만료 되었는지 체크
    public static bool isExpired(Date date)
    {
        if (Today.year > date.year) return true;
        else if (Today.year < date.year) return false;
        else
        {
            if (Today.month > date.month) return true;
            else if (Today.month < date.month) return false;
            else
            {
                if (Today.day > date.day) return true;
                else return false;
            }
        }
    }
}
public class Date
{
    public int year;
    public int month;
    public int day;

    public Date(string dateString)
    {
        string[] splitdate = dateString.Split('.');
        this.year = int.Parse(splitdate[0]);
        this.month = int.Parse(splitdate[1]);
        this.day = int.Parse(splitdate[2]);
    }

    //이후 날짜 구해기
    public Date AfterDate(int month)
    {
        if(month==0)return this;
        
        this.day--;
        this.month += month;
        
        ResizeDate();
        return this;    
    }

    //날짜 형식에 맞게 새로고침
    public void ResizeDate()
    {
        if (day < 1)
        {
            month--;
            day = 28;
        }
        else if (day > 28)
        {
            this.month++;
            this.day -= 28;
        }
        
        if (month > 12)
        {
            if (month % 12 == 0)
            {
                year += month / 12 - 1;
                month = 12;
            }
            else
            {
                year += month / 12;
                this.month %= 12;
            }
        }
    }
}

public class DDE
{
    public static void Main(string[] Args)
    {
        Solution solution = new Solution();

        string today = Console.ReadLine();
        int count1 = int.Parse(Console.ReadLine());
        int count2 = int.Parse(Console.ReadLine());

        string[] terms = new string[count1];
        string[] privacies = new string[count2];
        for (int i = 0; i < terms.Length; i++)
            terms[i] = Console.ReadLine();
        for (int i = 0; i < privacies.Length; i++)
            privacies[i] = Console.ReadLine();


        int[] ints = solution.solution(today, terms, privacies);
        for (int i = 0; i < ints.Length; i++)
        {
            Console.Write(ints[i] + " ");
        }
    }
}