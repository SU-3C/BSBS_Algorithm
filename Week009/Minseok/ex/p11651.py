# 11651 [s5] 좌표 정렬하기

import sys

input = sys.stdin.readline

_ = int(input())

arr = []

for x in range(_):
    arr.append(tuple(map(int, input().split())))

arr.sort(key=lambda x: x[0])
arr.sort(key=lambda x: x[1])

for x in arr:
    print(x[0], x[1])