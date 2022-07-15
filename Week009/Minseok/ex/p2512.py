# 2512 [s3] 예산

import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
M = int(input())


if sum(arr) < M:
    print(max(arr))
else:
    avg = M // N 
    print(avg)

