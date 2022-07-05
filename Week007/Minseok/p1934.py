# 1934 [b1] 최소공배수

import math

for x in range(int(input())):
    a, b = map(int, input().split())

    arr = []
    if a % 2 == 0 and b % 2 == 0:
        arr.append(2)
    for y in range(3, int(math.sqrt(max(a, b))), 2):
        if a % y == 0 and b % y == 0:
            arr.append(y)

    result = max(a, b)
    for y in arr:
        result *= y

    print(result)


