# 2493 [g5] 탑 - 푸는 중

from collections import deque
import sys

_ = int(sys.stdin.readline())
top = deque(map(int, sys.stdin.readline().split()))
sorted_top = sorted(top)

stack = deque()

while top and (t:=top.pop()):
    if top and max(top) < t:    # 값이 남은 탑의 최댓값보다 크면 0
        stack.append(0)
        continue

    x = len(top)
    flag = True
    while x > 0:    # O(N^N) 
        x -= 1
        # print(x)
        if top[x] > t:
            stack.append(x+1)
            flag = False
            break
    if flag:
        stack.append(0)

for x in range(len(stack)-1, -1, -1):
    print(stack[x], end=" ")



'''
_ = int(sys.stdin.readline())

top = deque(map(int, reversed(sys.stdin.readline().strip().split()))) # N
dic = deque()

while top:
    t = top.popleft() # N
    if not top or max(top) < t:
        dic.append(0)
        continue

    flag = True
    x = 0

    if max(top) < t:
        dic.append(0)
        continue

    while x < len(top): # N^N
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