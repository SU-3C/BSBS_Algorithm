
from time import time
from collections import deque

class Node:
    childs = None

    def __init__(self):
        self.childs = deque()

    def setChilds(self, ch):
        self.childs.append(ch)

tc = 30000000

def test1():
    t = [x for x in range(tc)]
    a = time()
    
    # create    

    arr1 = list(t)
    b = time()

    # copy

    arr2 = t.copy()
    c = time()

    # extend

    arr3 = []
    arr3.extend(t)
    d = time()

    # slice

    arr4 = t[:]
    e = time()

    # print(f'create: {b-a}')
    # print(f'copy: {c-b}')
    # print(f'extend: {d-c}')
    # print(f'slice: {e-d}')
    
    return b-a, c-b, d-c, e-d



def test2():
    t = deque([x for x in range(tc)])
    a = time()
    # create    

    arr1 = deque(t)
    b = time()

    # copy

    arr2 = t.copy()
    c = time()

    # extend

    arr3 = []
    arr3.extend(t)
    d = time()

    # print(f'create: {b-a}')
    # print(f'copy: {c-b}')
    # print(f'extend: {d-c}')

    return b-a, c-b, d-c


def test3():
    a = time()

    t = [0 for x in range(tc)]

    b = time()

    arr = t[:]
    for x in range(tc):
        arr[x] = 1

    c = time()

    arr2 = deque(t)
    for x in range(tc):
        arr2[x] = 1

    d = time()

    print()
    print(f'[:] = {b-a}')
    print(f'list {c-b}')
    print(f'dequ {d-c}')
    print()
    print(f'diff {(c-b) / (d-c)}')
    print()

def test4():
    t = [0 for x in range(tc)]

    a = time()

    arr = []
    for x in t:
        arr.append(x)

    b = time()

    arr2 = deque()
    for x in t:
        arr2.append(x)

    c = time()

    print()
    print(f'list {b-a}')
    print(f'dequ {c-b}')
    print()
    print(f'diff {(c-b) - (b-a)}')
    print()

def test5():
    t = deque([0 for x in range(tc)])

    a = time()

    arr = t.copy()

    b = time()

    arr2 = deque()
    arr2, t = t, arr2

    c = time()

    print(b-a)
    print(c-b)

    print()

    print((c-b)-(b-a))

    print()

def test6():
    t = deque([x for x in range(tc)])
    arr = t.copy()
    arr2 = t.copy()

    a = time()

    arr.clear()

    b = time()

    while arr2:
        arr2.pop()

    c = time()

    print(b-a)
    print(c-b)

    print()
    print((c-b)-(b-a))

for x in range(10):
    # q, w, e, r = test1()
    # a, s, d = test2()

    test6()

    # print(q, w, e)

    # print(f'create: {q-a}')
    # print(f'copy: {w-s}')
    # print(f'extend: {e-d}')
