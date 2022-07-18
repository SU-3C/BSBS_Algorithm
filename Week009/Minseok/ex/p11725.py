# 11725 [s2] 트리의 부모 찾기

import sys
input = sys.stdin.readline

i = int(input())

arr = [str(x) for x in range(1, i+1)]

for x in range(i-1):
    a, b= map(int, input().split())
    arr[a-1] = arr[a-1] + f' {b}'

print(arr)

