
/*

1. int total택배수, total수거수, 챙긴 택배 수, max택배집위치, max수거집위치, 이동거리
2. 챙길 수 있는 최대 택배 수 계산 : 총 택배 수가 cap 보다 크거나 같으면 cap or 작으면 총 택배수
3. max집위치부터 배열을 역으로 순회하여 택배와 수거 수행
    3-1. 택배 : max 집 위치부터 아래 수행
        -> 택배 수 0인 집은 pass
        -> 챙긴 택배수 >= 현재 집 택배 수 : 챙긴 택배 수 -= 현재 집 택배 수
        -> 챙긴 택배 수 < 현재 집 택배 수 : 현재 집 택배 수 -= 챙긴 택배 수, max택배 집 위치 = 현재 집 위치, 순회 종료
    3-2. 수거 택배와 동일하게 수행
4. 이동거리 += max집위치 *2

 */

class Solution {
    int curCap, maxDelIdx = -1, maxPickIdx = -1;
    long totalDel, totalPick, dist=0;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        for(int i = deliveries.length-1; i >= 0; i-- ){
            if (maxDelIdx < 0 && deliveries[i] > 0) maxDelIdx = i;
            if (maxPickIdx < 0 && pickups[i] > 0) maxPickIdx = i;
            totalDel += deliveries[i];
            totalPick += pickups[i];
        }

        while(totalPick > 0 || totalDel > 0){
            if (maxDelIdx >= maxPickIdx) dist += (maxDelIdx+1) *2;
            else dist += (maxPickIdx+1)*2;
            curCap = cap;
            for(int i = maxDelIdx; i >= 0; i--){
                if(deliveries[i] == 0) continue;
                else if (curCap >= deliveries[i]) {
                    curCap -= deliveries[i];
                    totalDel -= deliveries[i];
                }
                else {
                    deliveries[i] -= curCap;
                    totalDel -= curCap;
                    maxDelIdx = i;
                    break;
                }
                if (totalDel < 0) maxDelIdx = -1;
            }
            curCap = cap;
            for(int i = maxPickIdx; i >= 0; i--){
                if(pickups[i] == 0) continue;
                else if (curCap >= pickups[i]) {
                    curCap -= pickups[i];
                    totalPick -= pickups[i];
                }
                else {
                    pickups[i] -= curCap;
                    totalPick -= curCap;
                    maxPickIdx = i;
                    break;
                }
                if (totalPick < 0) maxPickIdx = -1;
            }
        }

        return dist;
    }
}
