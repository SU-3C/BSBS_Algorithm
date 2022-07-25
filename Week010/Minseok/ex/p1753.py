# 1753 [g4] 최단경로

import sys
input = sys.stdin.readline
sys.setrecursionlimit(300001)

from collections import deque

V, E = map(int, input().split())

K = int(input())


point = deque([-1 for x in range(V)])
line = deque([deque() for x in range(V)])

for x in range(E):
    u, v, w = map(int, input().split())
    line[u].append((v, w))

def bfs(i):
    

