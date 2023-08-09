# backjoon 컨베이어 벨트 위의 로봇

import sys
input = sys.stdin.readline
from collections import deque

# deque random aceess O(n)
# list del index 0 O(n)

def process(n, k, a):
    belt = a
    robots = [False for x in range(0, n)]
    zero = 0
    count = 0

    while True:
        belt, robots, zero = step(belt, robots, zero)
        count = count + 1

        # justShow(belt, robots)

        if zero >= k:
            break

    return count


def step(b, r, z):
    # step 1
    b[:0] = b.pop(),
    r[:0] = r.pop(),
    # b.append(b.pop(0))
    # r.append(r.pop(0))

    # step 2-0
    if r[-1]:
        r[-1] = False

    # step 2
    for x in range(len(r)-1, 0, -1):
        if r[x] and b[x+1] > 0 and not r[x+1]:
            r[x+1], r[x] = r[x], r[x+1]
            b[x+1] = b[x+1] - 1

            if b[x+1] == 0:
                z = z + 1

    # step 2-2
    if r[-1]:
        r[-1] = False

    # step 3
    if b[0] > 0:
        r[0] = True
        b[0] = b[0] - 1

        if b[0] == 0:
            z = z + 1

    return b, r, z


def justShow(b, r):
    for x in b:
        print(x, end=" ")
    print()
    for x in r:
        print(("■" if x else "□"), end="")
    print()


#'''
a, b = map(int, input().split())
arr = list(map(int, input().split()))
#'''

t = process(a, b, arr)
print(t)