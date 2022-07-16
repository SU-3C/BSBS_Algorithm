# 2512 [s3] 예산

import sys
input = sys.stdin.readline

N = int(input())
arr = list(sorted(map(int, input().split())))
M = int(input())

avg = M // N

if sum(arr) <= M:
    print(max(arr))
else:
    t = arr[:]
    for x in t:
        if avg >= x:
            M -= x
            arr.remove(x)

    t = arr[:]
    mx = -1
    for x in t:
        # print(f'x: {x} / {M} {len(arr)} {arr}')
        if M // len(arr) >= x:
            mx = M // len(arr)
            arr.remove(x)
            M -= x

    print(M // len(arr))
