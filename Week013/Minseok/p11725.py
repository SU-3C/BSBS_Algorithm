# 11725 [s1] 트리의 부모 찾기

import sys
input = sys.stdin.readline
sys.setrecursionlimit(2000000)

from collections import deque

class Node:
    hasParent = False
    lines = None

    def __init__(self):
        self.lines = deque()        

    def addline(self, li):
        self.lines.append(li)

    def getLines(self):
        return self.lines

    def delLine(self, delete):
        self.lines.remove(delete)


    def setParent(self):
        self.hasParent = True

N = int(input())

nodes = deque([Node() for x in range(N+1)])
heads = deque([0 for x in range(N+1)])

for x in range(N-1):
    a, b = map(int, input().split())

    nodes[a].addline(b)
    nodes[b].addline(a)

def search(node):
    for x in nodes[node].getLines():
        nodes[x].delLine(node)
        heads[x] = node
        search(x)
    
search(1)

heads.popleft()
heads.popleft()

for x in heads:
    print(x)