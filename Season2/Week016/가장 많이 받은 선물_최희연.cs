
/// <summary>
/// 친구이름 friends[] 2<= friends <=50 
/// 친구들이 주고 받은 선물 기록 gifts[] "A B" A->B 1<=gifts<=10000
/// return 다음달에 가장 많은 선물을 받을 사람의 선물 수
/// dic 를 dic<dic, num>
/// 안의 dic 은 dic<string, list>
/// 안의 list 는 선물 준사람 목록
/// 준 선물 양이 다를 경우, 누가 더 많이 받았는지 계산
/// 동점일 경우, 선물지수로 판단
/// 선물 지수는 리스트로 <사람, 준 선물- 받은 선물> 로 만들기
/// /// </summary>


using System;
using System.Collections.Generic;
using System.Linq;

    public class Solution
    {
        public int solution(string[] friends, string[] gifts)
        {

            int[] giftNums = new int[friends.Length]; //다음달에 받을 선물 (return 값)
            int[] giftComp = new int[friends.Length]; // 선물지수
            int[,] giftsArr = new int[friends.Length, friends.Length];

            // 이차원 배열에 값 매핑
            for (int i = 0; i < gifts.Length; i++)
            {
                int a = 0; int b = 0;
                string[] giftsString = gifts[i].Split(' ');
                for (int j = 0; j < friends.Length; j++)
                {
                    if (giftsString[0] == friends[j])
                    {
                        a = j;

                    }
                    if (giftsString[1] == friends[j])
                    {
                        b = j;

                    }
                }
                giftsArr[a, b] += 1;
            }

            //준 선물 더하기
            for (int i = 0; i < friends.Length; i++)
            {
                for (int j = 0; j < friends.Length; j++)
                {
                    if (giftsArr[i, j] != 0)
                    {
                        giftComp[i] += giftsArr[i, j];
                    }

                }

            }

            //받은선물 더하기 (준 선물에서 빼서 선물지수 구하기)
            for (int i = 0; i < friends.Length; i++)
            {
                for (int j = 0; j < friends.Length; j++)
                {
                    if (giftsArr[j, i] != 0)
                    {
                        giftComp[i] -= giftsArr[j, i];
                    }

                }

            }

            for (int i = 0; i < friends.Length; i++)
            {
                for (int j = i + 1; j < friends.Length; j++)
                {

                    if (giftsArr[i, j] == giftsArr[j, i])
                    {
                        if (giftComp[i] > giftComp[j])
                        {
                            giftNums[i] += 1;
                        }
                        else if (giftComp[i] < giftComp[j])
                        {
                            giftNums[j] += 1;
                        }
                    }
                    else if (giftsArr[i, j] > giftsArr[j, i])
                    {
                        giftNums[i] += 1;
                    }
                    else if (giftsArr[i, j] < giftsArr[j, i])
                    {
                        giftNums[j] += 1;
                    }
                }

            }

            return giftNums.Max();



        }
    }
