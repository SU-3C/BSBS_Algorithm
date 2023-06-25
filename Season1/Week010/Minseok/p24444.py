# 24444 [s2] 너비 우선 탐색 1

import sys
input = sys.stdin.readline

from collections import deque

sys.setrecursionlimit(2000000)

V, E, R = map(int, input().split())

visited = [0 for x in range(V+1)]
line = [[] for x in range(V+1)]

queue = deque() # 탐색용 큐

for x in range(E):
    a, b = map(int, input().split())

    line[a].append(b)
    line[b].append(a)

for x in line: # 오름차순 정렬
    x.sort()

cnt = 1

def bfs(i):
    # print(f'bfs {i}')
    global cnt # 전역변수 선언
    if visited[i]:  # 방문한 곳일 경우 종료
        return
    visited[i] = cnt
    cnt += 1

    for x in line[i]:
        queue.append(x)

    while queue:    # 큐에 들어있는 모든 장소 방문
        t = queue.popleft()
        bfs(t)

bfs(R) # R부터 BFS 탐색 시작

for x in visited[1:]:
    print(x)
