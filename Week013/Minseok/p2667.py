# 2667 [s1] 단지번호붙이기

import sys
input = sys.stdin.readline

from collections import deque

N = int(input())

maps = deque()
visited = deque(deque([0] * N) for x in range(N))

tu = [(0, -1), (-1, 0), (1, 0), (0, 1)] # 상하좌우 탐색

compelx = deque()
cnt = 0

for x in range(N):
    maps.append(deque(input().rstrip()))

def search(a, b):
    # print(f'r: {maps[a][b]} xy: {a}{b}')
    maps[a][b] = '0'

    for x, y in tu:
        if x+a == -1 or y+b == -1:
            continue
        # print(f'search xy {x+a}/{y+b} m{maps[x+a][y+b]} v{visited[x+a][y+b]}')
        try:
            if not visited[x+a][y+b]:
                if maps[x+a][y+b] == '1':
                    compelx[cnt] += 1
                    maps[x+a][y+b] = '0'
                    search(x+a, y+b)
        except:
            pass

for x in range(N):
    for y in range(N):
        # print(f'r: {maps[x][y]} xy: {x}/{y} visited: {visited[x][y]}')
        if visited[x][y]:
            continue

        visited[x][y] = '1'

        if maps[x][y] == '1':
            compelx.append(1)
            search(x, y)
            cnt += 1

        # for q1 in maps:
        #     print(f'{q1}')
        # print("=================")

print(len(compelx))

for x in sorted(compelx):
    print(x)

