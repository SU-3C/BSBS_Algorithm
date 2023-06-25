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
            # front 의 경우 가장 앞에 추가
        else:
            deque.append(x.split()[1])
            # back 의 경우 가장 뒤에 추가 

    elif "pop" in x:
        if empty:
            print(-1)
            continue

        if "front" in x:
            print(deque[0])
            del deque[0]
            # 가장 앞의 요소 제거
        else:
            print(deque[len(deque) - 1])
            del deque[len(deque) - 1]
            # 가장 뒤의 요소 제거

    elif "size" in x:
        print(len(deque))

    elif "empty" in x:
        print(1 if empty else 0)

    elif "front" in x:
        if empty:
            print(-1)
            continue
        print(deque[0])
        # 가장 앞 출력

    elif "back" in x: 
        if empty:
            print(-1)
            continue
        print(deque[len(deque) - 1])
        # 가장 뒤 출력