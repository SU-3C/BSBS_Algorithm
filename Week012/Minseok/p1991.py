# 1991 [s1] 트리 순회 2트

class Node: #이진트리 구조체 선언
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
    if dic.get(a) == None:  # 부모 노드가 None이라면
        dic[a] = Node()     # 부모 노드를 생성하고
        dic[a].set(a)       # 부모 노드 값 지정

    if b != ".": # '.' 이 아니면 자식에 추가
        dic[b] = Node()
        dic[b].set(b)
        dic[a].left = dic[b]

    if c != ".":
        dic[c] = Node()
        dic[c].set(c)
        dic[a].right = dic[c]


resf = deque() # 전위순회
resm = deque() # 중위순회
resl = deque() # 후위순회

def fscan(n):
    resf.append(n.me)   # 본인 탐색
    if n.left:          # 왼쪽 자식이 있다면 탐색
        fscan(n.left)
    if n.right:         # 오른쪽 자식이 있다면 탐색
        fscan(n.right)

def mscan(n):
    if n.left:          # 왼쪽 자식이 있다면 탐색
        mscan(n.left)
    resm.append(n.me)   # 본인 탐색
    if n.right:         # 오른쪽 자식이 있다면 탐색
        mscan(n.right)

def lscan(n):
    if n.left:          # 왼쪽 자식이 있다면 탐색
        lscan(n.left)
    if n.right:         # 오른쪽 자식이 있다면 탐색
        lscan(n.right)
    resl.append(n.me)   # 본인 탐색

def scan(n):
    resf.append(n.me)
    if n.left:
        scan(n.left)
    resm.append(n.me)
    if n.right:
        scan(n.right)
    resl.append(n.me)

scan(dic['A'])
*map(print, ["".join(resf), "".join(resm), "".join(resl)]),

#fscan(dic['A']) # 루트 노드는 'A' 지정(문제)
#mscan(dic['A'])
#lscan(dic['A'])
#
#print(f'{"".join(resf)}') # 배열 내 값을 문자열로 변환
#print(f'{"".join(resm)}')
#print(f'{"".join(resl)}')
