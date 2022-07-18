# 1003 [s3] 피보나치 함수

import sys

fibo = [0, 1]
fibo_cnt = [(1, 0), (0, 1)]

arr = [int(sys.stdin.readline()) for x in range(int(input()))]
resIndex = max(arr)
if resIndex < 2:
    pass
    # print(fibo[resIndex])
    # quit()
for x in range(1, resIndex):
    fibo.append(fibo[x]+fibo[x-1])
    cnt = tuple(map(lambda x,y: x+y, fibo_cnt[x], fibo_cnt[x-1]))
    fibo_cnt.append(cnt)

for x in arr:
    a, b = fibo_cnt[x]
    print(a, b)
