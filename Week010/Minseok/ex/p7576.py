# 7576 [g5] 토마토

import sys
input = sys.stdin.readline

from collections import deque

M, N = map(int, input().split())

tomato = deque()
search_table = deque()
search_temp = set()

walls = 0
day = 0

tu = [(0, -1), (-1, 0), (1, 0), (0, 1)]

for x in range(N):
    tomato.append(deque())
    for i, y in enumerate(map(int, input().split())):
        tomato[x].append(y)
        if y == 1:
            search_temp.add((x, i))
        elif y == -1:
            walls += 1

temp_value = M*N-len(search_temp) - walls

cnt = 0

def search(b, a):
    # print(f'ex: {tomato[b][a]}')
    global cnt
    cnt += 1
    global temp_value
    for q, w in tu:
        try:
            if b+w == -1 or a + q == -1:
                continue
            if tomato[b+w][a+q] == 0:
                search_temp.add((b+w, a+q))
                temp_value -= 1
                tomato[b+w][a+q] = tomato[b][a] + 1# 2
        except:
            pass

while True:
    day += 1
    t = 0 + temp_value
    if search_temp:
        search_table.clear()
        search_table.extend(search_temp)
        search_temp.clear()
    for x, y in search_table:
        search(x, y)

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
    # print(f'{temp_value} : {t}')
    # print()

    # for x in tomato:
    #     for y in x:
    #         if y == 0:
    #             print("■", end="")
    #         elif y == -1:
    #             print("□", end="")
    #         else:
    #             print(f"{y}", end="")
    #     print()
    # print(f'{temp_value} : {t}')
    # print()

    if temp_value == t:
        break

# q = sum(tomato, []).count(0)

print(-1 if temp_value > 0 else day-1)

#print(f'cnt: {cnt}')
