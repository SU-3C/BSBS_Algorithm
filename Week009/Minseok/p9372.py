# 9372 [s4] 상근이의 여행

import sys
input = sys.stdin.readline

class Point:
    me = None
    nexts = None

    def __init__(self):
        self.nexts = []

    def setMe(self, me):
        self.me = me

    def getMe(self):
        return self.me

    def appendNext(self, nxt):
        self.nexts.append(nxt)
        self.nexts.sort()

    def getNexts(self):
        return self.nexts

    def __len__(self):
        return len(self.nexts)

for _ in range(int(input())):
    Points = []
    
    N, M = map(int, input().split())
    
    for x in range(N):
        t = Point()
        t.setMe(x)
        Points.append(t)
    
    location = [x for x in range(N)] # 방문해야 할 나라
    tmp = location[:] 
    plane = set()
    
    start = None
    
    for x in range(M):
        a, b = map(int, input().split())
        plane.add((a, b))
        plane.add((b, a))

    plane = list(plane)
    
    for x in plane:
        a, b = x
        Points[a-1].appendNext(b-1)
        if len(Points[a-1]) == 1:
            tmp.remove(a-1)
    
    if tmp:
        start = tmp.pop()
    else:
        start = Points[0]
    
    cnt = [] # 사용한 비행기의 출발-도착지 튜플
    flag = 1
    while True:
        # print(f'l: {location}, me: {start.getMe()}, cnt: {cnt}, flag: {flag}')
        try:
            location.remove(start.getMe())
        except:
            pass
        if not location:
            print(len(set(cnt)))
            break
        find = False # 현재 위치에서 추가적으로 탐색 가능 여부
        for x in start.getNexts():
            if x in location:
                flag = 1
                a, b = start.getMe(), x
                cnt.append((a, b))
                start = Points[x]
                find = True
                break
        if not find: # 불가능할 경우 왔던 길을 되돌아감
            start = Points[cnt[-flag][0]]
            flag += 1


''' 문제 잘못풀었던 흔적

import sys
input = sys.stdin.readline

class Point:
    me = None
    nexts = None

    def __init__(self):
        self.nexts = []

    def setMe(self, me):
        self.me = me

    def getMe(self):
        return self.me

    def appendNext(self, nxt):
        self.nexts.append(nxt)
        self.nexts.sort()

    def getNexts(self):
        return self.nexts

    def __len__(self):
        return len(self.nexts)

for _ in range(int(input())):
    Points = []
    
    N, M = map(int, input().split())
    
    for x in range(N):
        t = Point()
        t.setMe(x)
        Points.append(t)
    
    location = [x for x in range(N)]
    tmp = location[:]
    plane = set()
    
    start = None
    
    for x in range(M):
        a, b = map(int, input().split())
        plane.add((a, b))
        plane.add((b, a))

    print(len(plane))
    plane = list(plane)
    
    for x in plane:
        a, b = x
        Points[a-1].appendNext(b-1)
        if len(Points[a-1]) == 1:
            tmp.remove(a-1)
    
    if tmp:
        start = tmp.pop()
    else:
        start = Points[0]
    
    cnt = []
    
    while True:
        # print(f'l: {location}, me: {start.getMe()}, cnt: {cnt}')
        try:
            location.remove(start.getMe())
        except:
            pass
        if not location:
            print(len(set(cnt)))
            break
        for x in start.getNexts():
            if x in location:
                a, b = min(start.getMe(), x), max(start.getMe(), x)
                cnt.append((a, b))
                start = Points[x]
                break
            else:
                start = Points[x]
'''