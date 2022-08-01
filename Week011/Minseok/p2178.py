# 2178 [s1] 미로 탐색

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000001)

from collections import deque

maze = []
Q = deque()
RQ = set()

N, M = map(int, input().split())

for x in range(N):
    maze.append(list(map(int, list(input().rstrip()))))

tu = [(0, -1), (-1, 0), (1, 0), (0, 1)]
cnt = 0

def search(a, b):
    if maze[b][a] == 9:
        return
    maze[b][a] = 9

    for x, y in tu:
        try:
            if b+x == -1 or a+y == -1:
                continue
            if maze[b+x][a+y] == 1:
                RQ.add((a+y, b+x))
        except:
            pass

Q.append((0, 0))


while maze[N-1][M-1] != 9:
    # input()
    cnt += 1
    RQ = set()
    while Q:
        t, y = Q.pop()
        search(t, y)
    # print(RQ)
    Q = deque(RQ)

    # for x in maze:
    #     print(x)

print(cnt)
