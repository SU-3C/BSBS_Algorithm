# 2108 [s3] 통계학

nums = [int(input()) for x in range(int(input()))]

nums.sort()

res1 = round(sum(nums) / len(nums))
res2 = nums[len(nums) // 2]
res4 = max(nums) - min(nums)

print(res1)
print(res2)

arr = {}

if len(nums) == len(set(nums)):
    if len(nums) > 2:
        print(nums[1])
    else:
        print(nums[0])
else:
    # while len(nums) != len(set(nums)):
    #     for x in set(nums):
    #         nums.remove(x)
    for x in set(nums):
        arr.update({x: nums.count(x)})

    res3 = [k for k,v in arr.items() if v == arr[max(arr.keys())]]

    print((res3[1] if len(res3) > 1 else res3[0]))

print(res4)
