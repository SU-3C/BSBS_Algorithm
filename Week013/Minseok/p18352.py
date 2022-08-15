# 18352 [s1] 특정 거리의 도시 찾기

import sys
input = sys.stdin.readline

from collections import deque

# N번까지의 도시
# M개의 단방향 도로
# K 거리 정보
# X 출발 도시

N, M, K, X = map(int, input().split())

lines = deque([deque() for x in range(N+1)])
visited = deque([-1 for x in range(N+1)])
res = deque()

for x in range(M):
    a, b = map(int, input().split())
    lines[a].append(b)

queue = deque()
tqueue = deque()
dep = 0

tqueue.append(X)

while True:
    if not queue:
        if dep == K:
            break
        queue = tqueue.copy()
        tqueue.clear()
        dep += 1

    # print(f'{queue} {tqueue}')
    q = queue.popleft()
    # print(f'q:{q}')

    for x in lines[q]:
        # print(f'{x} {visited[x]}')
        if visited[x] == -1:
            tqueue.append(x)
            visited[x] = dep

if len(tqueue) == 0:
    print(-1)
else:
    for x in sorted(tqueue):
        print(x)





