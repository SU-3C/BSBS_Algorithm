# 7432 [g3] 디스크 트리

import sys
input = sys.stdin.readline

from collections import deque

class FS():
    name = None
    childs = None
    cNames = None

    def __init__(self, name):
        self.name = name
        self.childs = deque()
        self.cNames = deque()

    def add(self, ch):
        self.childs.append(ch)
        self.cNames.append(ch.name)

N = int(input())

fs = FS('root')

for _ in range(N):
    path = input().rstrip().split("\\");
    # print(path)

    root = None

    if path[0] in fs.cNames:
        for x in fs.childs:
            if x.name == path[0]:
                root = x
                break
    else:
        root = FS(path[0])
        fs.add(root)

    for x in path[1:]:
        newNode = None
        if x in root.cNames:
            for y in root.childs:
                if y.name == x:
                    newNode = y
                    break
        else:
            newNode = FS(x)
            root.add(newNode)
            root.childs = sorted(root.childs, key=lambda x: x.name)
        root = newNode

fs.childs = sorted(fs.childs, key=lambda x: x.name)

def printChild(c, dep):
    # print(f'-{c.name}')
    print(" " *dep, end="")
    if c.name != "root":
        print(c.name)
    if len(c.childs) == 0:
        return
    for x in c.childs:
        printChild(x, dep+1)

printChild(fs, -1)


