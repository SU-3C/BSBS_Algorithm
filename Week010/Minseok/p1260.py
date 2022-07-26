# 1260 [s2] DFS와 BFS

import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

from collections import deque

a, b, c = map(int, input().split())

visited_dfs = [] # DFS 방문 저장
visited_bfs = [] # BFS 방문 저장

line=[[] for x in range(a+1)]
bfs_queue = deque() # BFS 탐색용 큐 선언


for x in range(b):
    q, w = map(int, input().split())
    line[q].append(w)
    line[w].append(q)

    # A < - > B 양방향 저장

for x in line:
    x.sort() # 오름차순 정렬

def dfs(i): 
    if i in visited_dfs: # 방문한 경우 종료
        return
    visited_dfs.append(i) # 방문처리
    for x in line[i]:
        dfs(x)
            
def bfs(i):
    if i in visited_bfs: # 방문한 경우 종료
        return
    visited_bfs.append(i) # 방문처리
    bfs_queue.append(i) # 
    for x in line[i]:
        if not x in visited_bfs: # 만약 큐에 '들어있지 않은 경우'에만
            bfs_queue.append(x) # 큐에 추가
    while bfs_queue:
        t = bfs_queue.popleft()    
        bfs(t)
        
dfs(c) # c부터 DFS 탐색 시작

for x in visited_dfs:
    print(x, end=" ")
print()

bfs(c) # c부터 BFS 탐색 시작

for x in visited_bfs:
    print(x, end=" ")
print()