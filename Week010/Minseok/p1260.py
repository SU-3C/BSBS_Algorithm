# 1260 [s2] DFS와 BFS

import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

from collections import deque

a, b, c = map(int, input().split())

visited_bfs = []
visited_dfs = []

line=[[] for x in range(a+1)]
bfs_queue = deque()


for x in range(b):
    q, w = map(int, input().split())
    line[q].append(w)
    line[w].append(q)

for x in line:
    x.sort()

start = c

def dfs(i):
    if i in visited_dfs:
        return;
    visited_dfs.append(i)
    for x in line[i]:
            dfs(x)
            
def bfs(i):
    if i in visited_bfs:
        return;
    visited_bfs.append(i)
    bfs_queue.append(i)
    for x in line[i]:
        if not x in visited_bfs:
            bfs_queue.append(x)
    while bfs_queue:
        t = bfs_queue.popleft()    
        bfs(t)
        
dfs(c)

for x in visited_dfs:
    print(x, end=" ")
print()

bfs(c)

for x in visited_bfs:
    print(x, end=" ")
print()