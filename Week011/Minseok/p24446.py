# 24446 [s2] 너비 우선 탐색 3

import sys
input = sys.stdin.readline

from collections import deque

sys.setrecursionlimit(2000000)

V, E, R = map(int, input().split())

visited = deque([-1 for x in range(V+1)])
line = [[] for x in range(V+1)]

queue = deque()

for x in range(E):
    a, b = map(int, input().split())

    line[a].append(b)
    line[b].append(a)

for x in line: # 내림 차순
    x.sort()

cnt = 1
side = 0

def bfs(i):
    global cnt
    global side
    # print(f'bfs {i} {visited[i]} c:{cnt} s:{side}')
    if visited[i] != -1:
        return
    # print(f'bfs {i} {c}')
    visited[i] = 0+cnt

    # print(f'l: {line[i]}')
    for x in line[i]:
        if visited[x] == -1:
            queue.append(x)
            # side += 1

    if side != 0:
        side -= 1

    # cnt += 1
    # print(f'q: {queue} {side}')
    while queue:
        if side == 0:
            side = len(queue) - queue.count(0)
            if side == 0:
                break
            queue.append(0)
            continue
        t = queue.popleft()
        # print(queue)
        if t == 0:
            cnt += 1
            continue
        bfs(t)

bfs(R)
visited[R] = 0

visited.popleft()
for x in visited:
    print(x)
