/*
 * 1.접근 방식
 * 먼 집부터 택배 배달과 수거를 하는 것이 최소 거리에 유리하다.
 * 먼 집 :: 배달하거나, 수거하는 양이 존재하는 집 증에 가장 먼 집
 * 다음과 같은 보장 아래 가능하다
 * a.집에 배달 및 수거할 때, 원하는 개수만큼 택배를 배달 및 수거할 수 있습니다.
 * => 수거 시에 공간이 부족하다 해도 배달 하는 도중 그만큼 배달하고 왔다고 생각하면 됨
 *
 * 2.풀이 방식
 * 스택을 이용해 저장 스택에는 현재 배달/수거를 하는 집의 <인덱스,남은 수량> 형태로 제공한다.
 * a.가장 먼 집의 위치를 구한다.(배달 스택/수거 스택의 top중 큰 인덱스)
 * b.배달할 스택의 상단 개수에서 4개를 뺀다(배달 스택에서 4뺌, 만일 부족하면pop)
 * c.수거할 스택의 상단 개수에서 4개를 뺀다(수거 스택에서 4뺌, 만일 부족하면pop)
 * d.만일 스택 둘이 전부 pop되지 않았다면 a로 돌아간다
 */

using System;
using System.Collections.Generic;

public class Solution
{
    static Stack<Count> deliveriesStack = new Stack<Count>(), pickupsStack = new Stack<Count>();

    public long solution(int cap, int n, int[] deliveries, int[] pickups)
    {
        long answer = 0;
        for (int i = 0; i < deliveries.Length; i++)
        {
            if (deliveries[i] == 0) continue;
            deliveriesStack.Push(new Count(i + 1, deliveries[i]));
        }

        for (int i = 0; i < pickups.Length; i++)
        {
            if (pickups[i] == 0) continue;
            pickupsStack.Push(new Count(i + 1, pickups[i]));
        }

        while (true)
        {
            int currentDistance=0;
            if (deliveriesStack.Count > 0 && pickupsStack.Count > 0)
            {
                currentDistance = Math.Max(deliveriesStack.Peek().index, pickupsStack.Peek().index);
            }
            else if (deliveriesStack.Count == 0 && pickupsStack.Count == 0)
            {
                break;
            }
            else if(deliveriesStack.Count==0)
            {
                currentDistance = pickupsStack.Peek().index;
            }
            else if(pickupsStack.Count==0)
            {
                currentDistance = deliveriesStack.Peek().index;
            }

            answer += currentDistance * 2;
            
            int remainDeliveriesCap = cap;

            while (remainDeliveriesCap > 0)
            {
                if(deliveriesStack.Count==0)break;
                if (deliveriesStack.Peek().count > remainDeliveriesCap)
                {
                    deliveriesStack.Peek().count -= remainDeliveriesCap;
                    remainDeliveriesCap = 0;
                }
                else
                {
                    remainDeliveriesCap-=deliveriesStack.Peek().count;
                    deliveriesStack.Pop();
                }
            }
            
            int remainpickUpCap = cap;

            while (remainpickUpCap > 0)
            {
                if(pickupsStack.Count==0)break;
                if (pickupsStack.Peek().count > remainpickUpCap)
                {
                    pickupsStack.Peek().count -= remainpickUpCap;
                    remainpickUpCap = 0;
                }
                else
                {
                    remainpickUpCap-=pickupsStack.Peek().count;
                    pickupsStack.Pop();
                }
            }

            if (deliveriesStack.Count == 0 && pickupsStack.Count == 0)
            {
                break;
            }
            
            
        }

        return answer;
    }

    class Count
    {
        public int index;
        public int count;

        public Count(int index, int count)
        {
            this.index = index;
            this.count = count;
        }
    }
}
