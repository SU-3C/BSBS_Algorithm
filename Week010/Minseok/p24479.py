# 24479 [s2] 깊이 우선 탐색 1

import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

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

def dfs(V):
    global cnt
    if visited[V]:
        return;
    visited[V] = 0+cnt
    cnt+=1
    for x in line[V]:
        dfs(x)

dfs(R)

for x in visited[1:]:
    print(x)

