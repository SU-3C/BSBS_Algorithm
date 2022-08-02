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

tu = [(0, -1), (-1, 0), (1, 0), (0, 1)] # 상하좌우 탐색
cnt = 0

def search(a, b):
    if maze[b][a] == 9:
        return
    maze[b][a] = 9

    for x, y in tu: # 상 하 좌 우를 탐색해 조건에 맞으면 탐색 시작
        try:
            if b+x == -1 or a+y == -1:
                continue
            if maze[b+x][a+y] == 1:
                RQ.add((a+y, b+x)) # 이동 가능한 경로를 임시 큐에 추가
        except:
            pass

Q.append((0, 0)) # 좌 상단 (0, 0) 부터 시작


while maze[N-1][M-1] != 9: # 우, 하단 (N-1, M-1) 위치로 이동했을 경우 종료
    # input()
    cnt += 1
    RQ = set() # RQ 초기화
    while Q:
        t, y = Q.pop()
        search(t, y)
    # print(RQ)
    Q = deque(RQ) # 임시 큐에서 큐로 이동

    # for x in maze:
    #     print(x)

print(cnt)
