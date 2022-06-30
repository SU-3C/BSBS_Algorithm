# 4949 [s4] 균형잡힌 세상

import sys

while (s:= sys.stdin.readline().rstrip()) != ".":
    stack = []
    res = True
    for x in s:
        if x == "(":
            stack.append('(')
        elif x == "[":
            stack.append('[')
        elif x == ")":
            if len(stack) != 0 and stack[-1] == "(":
                stack.pop()
            else:
                res = False
                break
        elif x == "]":
            if len(stack) != 0 and stack[-1] == "[":
                stack.pop()
            else:
                res = False
                break
        if x == ".":
            break

    if len(stack) != 0:
        res = False
    print("yes" if res else "no")