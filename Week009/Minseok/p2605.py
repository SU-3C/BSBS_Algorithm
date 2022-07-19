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

# LinkedList A -> B -> C를 
# A -> B, B -> C 이런 방식으로 구현

_ = int(input())
arr = deque(map(int, input().split()))

last = None

for i, x in enumerate(arr): # x is 뽑은 번호
    if last == None:
        last = LinkedList(i)
        continue
    if x == 0: # 0을 뽑은 경우 가장 뒤에 추가
        t = last
        ll = LinkedList(i) # A -> B 에서 A의 앞에 C를 추가
        ll.set(t)  # C -> A -> B
        last = ll
    else:
        t = last
        for y in range(x-1): # 뽑은 숫자만큼 앞으로 이동
            if (c:= t.get()):
                t = c

        ll = LinkedList(i)
        if (c:=t.get()): # A -> B -> C 에서 B -> C 사이에 D를 넣기 위해
            ll.set(c) # B -> D, D -> C를 처리해주는 부분
        t.set(ll)

    c = last

result = deque()

while True:
    result.appendleft(last.index)
    # 역순을 정순으로 변경 중
    if (c:=last.get()):
        last = c
    else: # LinkedList에서 아무것도 가리키고 있지 않다면 종료
        break

for x in result:
    print(x+1, end=" ")
