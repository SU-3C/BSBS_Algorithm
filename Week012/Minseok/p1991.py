# 1991 [s1] 트리 순회 2트

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

N = int(input())

dic = dict([(chr(65+x), None) for x in range(0, N)])

for x in range(N):
    a, b, c = input().split()
    if dic.get(a) == None:
        dic[a] = Node()
        dic[a].set(a)

    if b != ".":
        dic[b] = Node()
        dic[b].set(b)
        dic[a].left = dic[b]

    if c != ".":
        dic[c] = Node()
        dic[c].set(c)
        dic[a].right = dic[c]


resf = deque()
resm = deque()
resl = deque()

def fscan(n):
    resf.append(n.me)
    if n.left:
        fscan(n.left)
    if n.right:
        fscan(n.right)

def mscan(n):
    if n.left:
        mscan(n.left)
    resm.append(n.me)
    if n.right:
        mscan(n.right)

def lscan(n):
    if n.left:
        lscan(n.left)
    if n.right:
        lscan(n.right)
    resl.append(n.me)

fscan(dic['A'])
mscan(dic['A'])
lscan(dic['A'])

print(f'{"".join(resf)}')
print(f'{"".join(resm)}')
print(f'{"".join(resl)}')
