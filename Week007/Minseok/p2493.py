# 2493 [g5] 탑

from collections import deque
import sys

_ = int(sys.stdin.readline())



'''
top = deque(map(int, reversed(sys.stdin.readline().strip().split()))) # N
dic = deque()

while top:
    t = top.popleft() # N
    if not top or max(top) < t:
        dic.append(0)
        continue

    flag = True
    x = 0
    while x < len(top): # N^N
        # print(f'{top[x]} {t}')
        if top[x] > t:
            dic.append(len(top) - x) # N
            flag = False
            break
        x += 1
    if flag: 
        dic.append(0)

for v in reversed(dic): # N
    print(v, end=" ")

'''