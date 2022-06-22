# 10845 [s4] 큐

import sys

cmd = [sys.stdin.readline() for x in range(int(sys.stdin.readline()))]

queue = []
head = 0
tail = 0

for x in cmd:
    empty = tail == head
    #print(f'empty: {empty} / cmd: {x}')

    if "push" in x:
        queue.append(x.split()[1])
        # queue[head] = 1 # x.split(" ")
        head += 1

    elif "pop" in x:
        if empty:
            print(-1)
            continue

        print(queue[tail])
        tail += 1

    elif "size" in x:
        print(head - tail)

    elif "empty" in x:
        print(1 if empty else 0)

    elif "front" in x:
        print(-1 if empty else queue[tail])

    elif "back" in x:
        print(-1 if empty else queue[head-1])

