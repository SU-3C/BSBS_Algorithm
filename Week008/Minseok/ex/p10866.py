# 10866 [s4] 덱

import sys

cmd = [sys.stdin.readline() for x in range(int(sys.stdin.readline()))]

deque = []


for x in cmd:
    empty = len(deque) == 0
    if not empty:
        # print(f'cmd: {x} / d:{deque}')
        pass
    if "push" in x:
        if "front" in x:
            deque[0:0] = x.split()[1],
        else:
            deque.append(x.split()[1])

    elif "pop" in x:
        if empty:
            print(-1)
            continue

        if "front" in x:
            print(deque[0])
            del deque[0]
        else:
            print(deque[len(deque) - 1])
            del deque[len(deque) - 1]

    elif "size" in x:
        print(len(deque))

    elif "empty" in x:
        print(1 if empty else 0)

    elif "front" in x:
        if empty:
            print(-1)
            continue
        print(deque[0])

    elif "back" in x: 
        if empty:
            print(-1)
            continue
        print(deque[len(deque) - 1])