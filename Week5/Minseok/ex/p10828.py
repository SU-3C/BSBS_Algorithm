# 10828 [s4] 스택

import sys

cmd = [sys.stdin.readline() for x in range(int(sys.stdin.readline()))]

stack = []
point = 0

for x in cmd:
    empty = point == 0
    # print(f'empty: {empty} / cmd: {x}')

    if "push" in x:
        stack.append(x.split()[1])
        point += 1

    elif "pop" in x:
        if empty:
            print(-1)
            continue
        print(stack[point-1])
        del stack[point-1]
        point -= 1

    elif "size" in x:
        print(point)

    elif "empty" in x:
        print(1 if empty else 0)

    elif "top" in x:
        print(-1 if empty else stack[point-1])

