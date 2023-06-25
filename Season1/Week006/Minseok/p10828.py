# 10828 [s4] 스택

import sys

cmd = [sys.stdin.readline() for x in range(int(sys.stdin.readline()))]
# 명령어 배열 입력

stack = [] # 스택 관리용 List
point = 0 # 포인터(SP)

for x in cmd:
    empty = point == 0  # point가 0이면 스택이 비어있음을 의미
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

