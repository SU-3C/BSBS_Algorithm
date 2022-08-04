# 9934 [s1] 완전 이진 트리

class Node:
    me = -1
    left = None
    right = None

    def __init__(self):
        pass

    def set(self, me):
        self.me = me

import sys
input = sys.stdin.readline

from collections import deque

K = int(input())
tK = 0+K
# buildings = map(int, input().split())

arr = deque()
cnt = 1

n = Node()
n.me = cnt

arr.append(n)
tarr = deque()

while tK-1>0:
    print(f'{tK} {len(arr)}')
    t = arr.popleft()
    t.left = Node()
    cnt += 1
    t.left.set(0+cnt) 
    t.right = Node()
    cnt += 1
    t.right.set(0+cnt)

    print(f'm- {t.left.me} {t.right.me}')

    tarr.append(t.left)
    tarr.append(t.right)
    if len(arr) == 0:
        arr.extend(tarr)
        tarr.clear() 
        tK -= 1

print(f'L==========')


arr.clear()
arr.append(n)

while K>0:
    # input()
    t = arr.popleft()
    print(f'me: {t.me} len:{len(arr)}')

    if t.left != None:
        tarr.append(t.left)
        tarr.append(t.right)
    if len(arr) == 0:
        arr.extend(tarr)
        tarr.clear()
        K -= 1


# N
# N의 왼쪽
# N의 오른쪽
# 