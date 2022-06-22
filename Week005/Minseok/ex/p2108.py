# 2108 [s3] 통계학

import sys
from collections import Counter

nums = [int(sys.stdin.readline()) for x in range(int(sys.stdin.readline()))]

nums.sort()

length = len(nums)

res1 = round(sum(nums) / length)
res2 = nums[length // 2]
res4 = nums[-1] - nums[0]

print(res1)
print(res2)

dic = {}

if length == len(set(nums)):
    if length > 2:
        print(nums[1])
    else:
        print(nums[0])
else:
    c = Counter(nums)
    max_key = c.most_common(1)[0][1]
    res3 = [k for k,v in c.items() if v == max_key]

    print((res3[1] if len(res3) > 1 else res3[0]))

print(res4)
