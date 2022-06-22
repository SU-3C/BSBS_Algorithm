# 9012 [s4] 괄호

import sys

loop = int(sys.stdin.readline())
while loop > 0:
    loop -= 1
    temp = 0
    VPS = True # Valid PS 여부

    for x in input():
        if x == "(":
            temp += 1
        else:
            if temp < 1:
                VPS = False # 짝이 안맞음
                break
            temp -= 1

    print("NO" if not VPS else ("YES" if temp == 0 else "NO"))
    # VPS가 참이면서 temp가 0이면 YES, 아닐경우 NO