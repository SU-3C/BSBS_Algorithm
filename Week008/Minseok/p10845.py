# 10845 [s4] 큐

import sys

cmd = [sys.stdin.readline() for x in range(int(sys.stdin.readline()))]

queue = []
head = 0
tail = 0

for x in cmd:
    empty = tail == head # head 와 tail이 같다면 size가 0, 즉 empty = True
    # print(f'empty: {empty} / cmd: {x}')
    # empty 여부와 명령을 print 하는 방식으로 디버깅

    if "push" in x:
        queue.append(x.split()[1])  
        # push의 뒤에오는 부분을 배열에 추가
        head += 1 # 다음 push 시 들어가는 부분

    elif "pop" in x:
        if empty:
            print(-1)
            continue

        print(queue[tail])
        tail += 1   # 다음 pop 시 호출되는 부분

    elif "size" in x:
        print(head - tail) # head - tail = 현재 배열에 들어가 있는 값의 수

    elif "empty" in x:
        print(1 if empty else 0)

    elif "front" in x:
        print(-1 if empty else queue[tail])
        # 배열의 가장 앞

    elif "back" in x:
        print(-1 if empty else queue[head-1])
        # 배열의 가장 뒤

