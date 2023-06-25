# 2751 [s5] 수 정렬하기2

import sys

nums = [int(sys.stdin.readline()) for x in range(int(sys.stdin.readline()))]

nums.sort()

for x in nums:
    print(x)