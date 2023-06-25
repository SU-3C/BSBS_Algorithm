# 1916 [g5] 최소비용 구하기

import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

from collections import deque

# 도시의 개수
N = int(input())

# 버스의 개수
M = int(input())

bus = [[-1 if x==y else 100001 for y in range(N+1)] for x in range(N+1)]
value = [x for x in range(N+1)]

for x in range(M):
    a, b, c = map(int, input().split())
    if bus[a][b] > c:
        bus[a][b] = c


start, end = map(int, input().split())


# 28 ~ 39 가격표 시각화

t = [x for x in range(N)]

print("         ", end="")
for x in t:
    print(f'{x+1:6}', end=" | ")
print("\n========================================================")

for x in range(N):
    print(f'{t[x]+1:6} =', end=" ")
    for y in range(N):
        print(f'{bus[x+1][y+1]:6}', end=" | ")
    print()


