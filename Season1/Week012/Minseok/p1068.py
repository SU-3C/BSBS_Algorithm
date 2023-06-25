# 1068 [g5] 트리

import sys
input = sys.stdin.readline

from collections import deque

class Node:
    me = -1 # 본인을 나타낼 변수
    childs = None # 자식들을 관리할 배열

    def __init__(self, me):
        self.me = 0+me
        self.childs = deque() # 초기화

    def add(self, ch):
        self.childs.append(ch) # 배열에 추가

N = int(input())

dic = [Node(x) for x in range(N)]# dict([(chr(65+x), None) for x in range(0, N)])

#print(f'{len(dic)} {dic}')
arr = map(int, input().split())

dn = int(input()) # 삭제할 노드

tops = deque() # 부모가 -1이면 top노드
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
        if x.me == dn: # 탐색 도중 자식이 삭제할 노드라면
            flag = True
            continue
        scan(x)
    if flag and len(n.childs) == 1:
        n.childs.clear() # 자식이 하나였을 경우 본인이 리프노드가 됨
    if len(n.childs) == 0:
        res[cnt] += 1 

for x in tops: # 모든 탑 노드부터 스캔 시작
    # print(f'start {x.me}')
    if dn != x.me:
        scan(x)
    cnt += 1

print(f'{max(res)}') # 가장 큰 리프노드의 갯수를 출력