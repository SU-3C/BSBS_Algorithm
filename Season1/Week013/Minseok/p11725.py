# 11725 [s1] 트리의 부모 찾기

import sys
input = sys.stdin.readline
sys.setrecursionlimit(2000000)

from collections import deque

class Node:
    lines = None

    def __init__(self):
        self.lines = deque()        

    def addline(self, li): # 간선 저장
        self.lines.append(li)

    def getLines(self):
        return self.lines

    def delLine(self, delete):
        self.lines.remove(delete)

N = int(input())

nodes = deque([Node() for x in range(N+1)])
heads = deque([0 for x in range(N+1)]) # 부모를 저장할 노드

for x in range(N-1):
    a, b = map(int, input().split())

    nodes[a].addline(b) # 간선을 양쪽에 추가
    nodes[b].addline(a)

def search(node):
    for x in nodes[node].getLines():
        nodes[x].delLine(node) # 부모-자식을 연결한 후 간선 삭제
        heads[x] = node
        search(x)
    
search(1) # 트리의 루트는 1로 고정, 1부터 탐색 시작

heads.popleft()
heads.popleft()

for x in heads:
    print(x)