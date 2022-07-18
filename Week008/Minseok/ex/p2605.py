# 2605 [b2] 줄 세우기

from collections import deque

class LinkedList:
    index = -1
    tail = None

    def __init__(self, index):
        self.index = index

    def set(self, tail):
        self.tail = tail

    def get(self):
        if self.tail != None:
            return self.tail
        else:
            return False

_ = int(input())
arr = deque(map(int, input().split()))

last = None

for i, x in enumerate(arr): # x is 뽑은 번호
    # print(f'ix: {i} {x}')
    if last == None:
        last = LinkedList(i)
        continue
    if x == 0:
        t = last
        ll = LinkedList(i)
        ll.set(t)
        # print(f'last: {hex(id(last))}\n  ll: {hex(id(ll))}')
        last = ll
    else:
        t = last
        for y in range(x-1):
            if (c:= t.get()):
                t = c
            # print(f'y: {y}, c: {c.index}')
        # print(f'last: {last.index}\n   t: {t.index}')

        ll = LinkedList(i)
        if (c:=t.get()):
            ll.set(c)
        t.set(ll)
        # print(f'{t.index} {t.tail}')

    c = last
    '''
    while True:
        print(f"-> {c.index}", end=" ")
        if not (c:=c.get()):
            break
    print()
    '''

cnt = 1
result = deque()

while True:
    # print(f'last.idx {last.index}')
    result.appendleft(last.index)

    cnt += 1
    if (c:=last.get()):
        last = c
    else:
        break

for x in result:
    print(x+1, end=" ")
