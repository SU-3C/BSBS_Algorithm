# 2636 [g4] 치즈

import sys
input = sys.stdin.readline

a, b = map(int, input().split())

cheese = []

for _ in range(a):
    cheese.append(list(map(int, input().split())))

tu = [(0, -1), (-1, 0), (1, 0), (0, 1)]


def search(a, b):
    if cheese[b][a] == 9 or cheese[b][a] == 2:
        return False
    elif cheese[b][a] == 1:
        return True
    cheese[b][a] = 9
    for q, w in tu:
        try:
            if a+q == -1 or b+w == -1:
                continue
            if search(a+q, b+w):
                cheese[b+w][a+q] = 2
        except:
            pass

def count():
    i = 0
    for x in range(a):
        i += cheese[x].count(1)
        for y in range(b):
            if cheese[x][y] == 2 or cheese[x][y] == 9:
                cheese[x][y] = 0
    return i

cnt = 0
last = count()

while (c:=count()) != 0:
    last = c
    cnt += 1
    # print(f'last: {last}, cnt: {cnt}')
    search(0, 0)

    # for x in cheese:
    #     # print(x)
    #     for y in x:
    #         if y == 1:
    #             print("☆",end="")
    #         elif y == 2:
    #             print("★",end="")
    #         elif y == 9:
    #             print("□",end="")
    #         elif y == 0:
    #             print("■",end="")
    #     print()
    # print()

print(cnt)
print(last)