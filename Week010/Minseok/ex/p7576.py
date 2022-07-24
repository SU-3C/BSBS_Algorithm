# 7576 [g5] 토마토

import sys
input = sys.stdin.readline

from collections import deque

M, N = map(int, input().split())

tomato = []
search_table = deque()
search_temp = set()
for _ in range(N):
    tomato.append(list(map(int, input().split())))

tu = [(0, -1), (-1, 0), (1, 0), (0, 1)]

for x in range(M):
    for y in range(N):
        if tomato[y][x] == 1:
            search_table.append((y, x))

def search(b, a):
    for q, w in tu:
        # print(f'|{a+q}, {b+w}')
        try:
            # print(f'|{b+w},{a+q} {tomato[b+w][a+q]} {tomato[b+w][a+q] == 0 or tomato[b+w][a+q] == 9}')
            if b+w == -1 or a + q == -1:
                continue
            if tomato[b+w][a+q] == 0:
                # search_temp.append((b+w, a+q))
                search_temp.add((b+w, a+q))
                tomato[b+w][a+q] = 2
        except:
            pass

def count(arr):
    i = 0
    for x in range(N):
        i += arr[x].count(0)
        for y in range(M):
            if arr[x][y] == 2:
                arr[x][y] = 1
    return i

cnt = 0
z = count(tomato)
while True:
    if z == 0:
        break
    cnt += 1

    search_temp = set()
    while search_table:
        t = search_table.pop()
        # print(t)
        x, y = t
        search(x, y)
    # print(search_temp)
    search_table = deque(search_temp)

    # for x in tomato:
    #     for y in x:
    #         if y == 0:
    #             print("■", end="")
    #         elif y == 1:
    #             print("★", end="")
    #         elif y == 2:
    #             print("☆", end="")
    #         elif y == -1:
    #             print("□", end="")
    #     print()
    # print()
    
    # print()


    x = count(tomato)

    if z == x:
        if x > 0:
            cnt = -1
        break
    z = x

print(cnt)