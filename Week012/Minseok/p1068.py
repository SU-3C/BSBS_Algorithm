# 1068 [g5] 트리

import sys
input = sys.stdin.readline

from collections import deque

class Node:
    me = -1
    childs = None

    def __init__(self, me):
        self.me = 0+me
        self.childs = deque()

    def add(self, ch):
        self.childs.append(ch)

N = int(input())

dic = [Node(x) for x in range(N)]# dict([(chr(65+x), None) for x in range(0, N)])

#print(f'{len(dic)} {dic}')
arr = map(int, input().split())

dn = int(input())

tops = deque()
for i, x in enumerate(arr):
    # print(f'f i{i} x{x}')
    if x == -1:
        tops.append(dic[i])
        continue
    dic[x].add(dic[i])

res = deque([0 for x in range(len(tops))])

cnt = 0
def scan(n):
    global cnt
    flag = False
    for x in n.childs:
        # print(f'{n.me} scan {x.me} {dn}=={x.me==dn}')
        if x.me == dn:
            flag = True
            continue
        scan(x)
    if flag and len(n.childs) == 1:
        n.childs.clear()
    if len(n.childs) == 0:
        res[cnt] += 1

for x in tops:
    # print(f'start {x.me}')
    if dn != x.me:
        scan(x)
    cnt += 1

print(f'{max(res)}')