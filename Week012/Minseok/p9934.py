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
buildings = deque(map(int, input().split()))

arr = deque()
cnt = 1

n = Node()
n.me = cnt

arr.append(n)
tarr = deque()


# 이진트리 생성
while tK-1>0:
    # print(f'{tK} {len(arr)}')
    t = arr.popleft()
    t.left = Node()
    cnt += 1
    t.left.set(0+cnt) 
    t.right = Node()
    cnt += 1
    t.right.set(0+cnt)

    # print(f'm- {t.left.me} {t.right.me}')

    tarr.append(t.left)
    tarr.append(t.right)
    if len(arr) == 0:
        arr.extend(tarr)
        tarr.clear() 
        tK -= 1

cnt = 0

def scan(n):
    global cnt
    if n.left != None:
        scan(n.left)
    n.me = buildings[cnt]
    cnt += 1
    if n.right != None:
        scan(n.right)

scan(n)



# 최종 출력

arr.clear()
arr.append(n)

while K>0:
    # input()
    t = arr.popleft()
    print(f'{t.me}', end=" ")

    if t.left != None:
        tarr.append(t.left)
        tarr.append(t.right)
    if len(arr) == 0:
        arr.extend(tarr)
        tarr.clear()
        print()
        K -= 1

# 그냥 중위 순회