/*
 *  가장 많이 받은 선물
 * 요구사항
 *  1.두 사람이 선물을 주고받은 기록이 있다면
 *        두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받음
 *  2.두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다
 *        선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값
 *              예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7
 *               B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다,
 *  3.약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
 *
 *
 * 풀이 과정
 * 각 인원 별로 객체를 구성하여 선물 받은 기록을 관리
 *
 * Class GiftPeople
 *     Dictionary<string,int> sendArray
 *     Dictionary<string,int> receiveArray
 *     int giftValue
 *
 * Class Solution
 *   public Dictionary<string,GiftPeople>
 *   public void SendGift(string , string)
 *   public void ApplyResult(string name)
 */

using System;
using System.Collections.Generic;
using System.Linq;


public class Solution
{
    public Dictionary<string, GiftPeople> GiftPeoples = new Dictionary<string, GiftPeople>();
        
    public int solution(string[] friends, string[] gifts)
    {
        List<int> resultList = new List<int>();
        
        // 1.friends안의 원소 만큼 딕셔녀리에 할당
        foreach (var friend in friends)
        {
            GiftPeoples.Add(friend, new GiftPeople());
        }
        
        // 2.선물 주고받았던 기록 저장
        foreach (var gift in gifts)
        {
            string[] cmd = gift.Split();
            string send = cmd[0];
            string receive = cmd[1];
            SendGift(send, receive);
        }

        // 3. 선물 지수 계산
        foreach (var giftPeople in GiftPeoples)
        {
            giftPeople.Value.CalcGiftValue();
        }

        // 4.다음 달에 누가 선물을 많이 받을지 예측
        foreach (var friend in friends)
        {
            resultList.Add(ApplyResult(friend));
        }

        return resultList.Max();
    }
    
    public void SendGift(string sendName, string receiveName)
    {    
        GiftPeoples[sendName].Send(receiveName);
        GiftPeoples[receiveName].Receive(sendName);
    }

    public int ApplyResult(string name)
    {
        int total = 0;
        
        string[] keys = GiftPeoples.Keys.ToArray();

        foreach (var key in keys)
        {
            if (!name.Equals(key))
            {
                if (GiftPeoples[name].SendValue(key) == GiftPeoples[name].ReciveValue(key))
                {
                    if (GiftPeoples[name].giftValue > GiftPeoples[key].giftValue)
                    {
                        total++;
                    }   
                }
                else if (GiftPeoples[name].SendValue(key) > 0 || GiftPeoples[name].ReciveValue(key) > 0)
                {
                    if (GiftPeoples[name].SendValue(key) > GiftPeoples[name].ReciveValue(key))
                    {
                        total++;
                    }
                }
            }
        }

        return total;
    }
    
    public static void Main(string[] args)
    {
        string[] friends = { "joy", "brad", "alessandro", "conan", "david" };
        string[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        Console.WriteLine(new Solution().solution(friends,gifts));
    }
    public class GiftPeople
    {
        public Dictionary<string, int> sendArray=new Dictionary<string, int>();
        public Dictionary<string, int> receiveArray=new Dictionary<string, int>();
        public int giftValue;


        public void Send(string name)
        {
            if (!sendArray.ContainsKey(name))
            {
                sendArray.Add(name, 0);
            }

            sendArray[name]++;
        }
        public void Receive(string name)
        {
            
            if (!receiveArray.ContainsKey(name))
            {
                receiveArray.Add(name, 0);
            }

            receiveArray[name]++;
        }

        public void CalcGiftValue()
        {
            int SendValue=0, ReceiveValue=0;
            
            foreach (var send in sendArray)
            {
                SendValue += send.Value;
            }
            foreach (var receive in receiveArray)
            {
                ReceiveValue += receive.Value;
            }

            giftValue = SendValue - ReceiveValue;
        }

        public int SendValue(string name)
        {
            return !sendArray.ContainsKey(name) ? 0 : sendArray[name];
        }
        public int ReciveValue(string name)
        {
            return !receiveArray.ContainsKey(name) ? 0 : receiveArray[name];
        }
    }
}
