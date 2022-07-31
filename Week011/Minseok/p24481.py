# 24481 [s2] 깊이 우선 탐색 3

import sys
input = sys.stdin.readline
sys.setrecursionlimit(2000000)

V, E, R = map(int, input().split())

visited = [0 for x in range(V+1)] # False 초기화
line = [[] for x in range(V+1)]

for x in range(E): # 간선 입력
    u, v = map(int, input().split())
    line[u].append(v)
    line[v].append(u)

for x in line:
    x.sort()

cnt = 1
dep = 1

def dfs(V, d):
    global cnt
    if visited[V]:
        return;
    print(f'dfs{V} {d}')
    visited[V] = 0+d # N번쨰 방문 처리
    cnt+=1
    for x in line[V]:
        if visited[x]:
            continue
        dfs(x, d+1)

dfs(R, dep) # R부터 시작

for x in visited[1:]:
    print(x-1 if x != 0 else -1)