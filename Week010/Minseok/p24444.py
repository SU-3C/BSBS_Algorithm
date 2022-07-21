# 24444 [s2] 너비 우선 탐색 1

import sys
input = sys.stdin.readline

from collections import deque

sys.setrecursionlimit(2000000)

V, E, R = map(int, input().split())

visited = [0 for x in range(V+1)]
line = [[] for x in range(V+1)]

queue = deque()

for x in range(E):
    a, b = map(int, input().split())

    line[a].append(b)
    line[b].append(a)

for x in line:
    x.sort()

cnt = 1

def bfs(i):
    # print(f'bfs {i}')
    global cnt
    if visited[i]:
        return
    visited[i] = cnt
    cnt += 1

    for x in line[i]:
        queue.append(x)

    while queue:
        t = queue.popleft()
        bfs(t)

bfs(R)

for x in visited[1:]:
    print(x)
