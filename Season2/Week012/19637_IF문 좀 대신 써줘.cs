using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

public class BOJ_19637
{
    public static Dictionary<int, string> TitleDic = new Dictionary<int, string>();
    public static List<int> powerList = new List<int>();
    private static int n, m;
    public static StreamReader sr = new StreamReader(Console.OpenStandardInput());

    public void Initialize()
    {
        int[] input1 = Array.ConvertAll(sr.ReadLine().Split(), int.Parse);
        n = input1[0];
        m = input1[1];

        for (int i = 0; i < n; i++)
        {
            string[] command = sr.ReadLine().Split();
            int number = int.Parse(command[1]);

            if (!TitleDic.ContainsKey(number))
            {
                TitleDic.Add(number, command[0]);
                powerList.Add(number);
            }
        }
    }

    public int BinarySearch(int target)
    {
        if (target <= powerList[0])
        {
            return powerList[0];
        }
        if (target > powerList[powerList.Count - 1])
        {
            return powerList[powerList.Count - 1];
        }

        int start = 0;
        int end = powerList.Count;

        while(start < end)
        {
            int mid = start + ((end - start) / 2);

            if(powerList[mid] < target)
                start = mid + 1;
            else 
                end = mid;
             
        }

        return powerList[start == powerList.Count ? start - 1 : start];
    }


    public string GetTitle(int number)
    {
        return TitleDic[BinarySearch(number)];
    }

    public static void Main()
    {   
        BOJ_19637 boj19637=new BOJ_19637();
        boj19637.Initialize();

        StringBuilder result = new StringBuilder();
       
        for(int i=0;i<m;i++){
            result.Append(boj19637.GetTitle(int.Parse(sr.ReadLine()))+"\n");
        }
       
        Console.Write(result.ToString());
      
        sr.Close();
      
    } 
}
