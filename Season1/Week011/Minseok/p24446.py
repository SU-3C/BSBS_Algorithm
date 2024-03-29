# 24446 [s2] 너비 우선 탐색 3

import sys
input = sys.stdin.readline

from collections import deque

sys.setrecursionlimit(2000000)

V, E, R = map(int, input().split())

visited = deque([0 for x in range(V+1)])

line = [[] for x in range(V+1)]
depths = deque([-1 for x in range(V+1)])

access = deque([1 for x in range(V+1)])

queue = deque()
temp_queue = deque()

for x in range(E):
    a, b = map(int, input().split())

    line[a].append(b)
    line[b].append(a)

for x in line: # 내림 차순
    x.sort()

dep = 0

def bfs(i):
    global dep
    if not visited:
        return
    visited[i] = 1
    access[i] = 0

    # print(f'{i} {depths}')

    for x in line[i]:
        # print(f'x{x} v{not visited[x]} t{not x in temp_queue}')
        if access[x]: # 접근 제어용 배열
            temp_queue.append(x)
            access[x] = 0

    while queue:
        # print(f'now queue: {queue}')
        t = queue.popleft()
        if t == 0: # 0일 경우 임시배열을 배열에 통합 후 깊이에 +1
            dep += 1
            queue.extend(temp_queue)
            temp_queue.clear() # 임시배열 비우기
            continue
        depths[t] = 0+dep
        if not queue:
            # 배열이 비어있다면 0을 배열에 추가
            # print(f'nq: {temp_queue}')
            queue.append(0)
        bfs(t)

queue.append(0)
depths[R] = 0
bfs(R)

depths.popleft()
for x in depths:
    # print(f'{q} {x}')
    print(x)
