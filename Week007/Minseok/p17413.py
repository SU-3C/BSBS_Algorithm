# 17413 [s3] 단어 뒤집기 2

import sys
from collections import deque

string = deque(sys.stdin.readline().rstrip())

stack = deque()
temp_stack = deque()

while string:
    a = string.popleft()
    if a == "<":
        if temp_stack:
            while temp_stack:
                stack.append(temp_stack.pop())

        stack.append(a)
        while True:
            b = string.popleft()
            stack.append(b)
            if b == ">":
                break
    else:
        if a == " ":
            if temp_stack:
                while temp_stack:
                    stack.append(temp_stack.pop())
            stack.append(a)
        else:
            temp_stack.append(a)

if temp_stack:
    while temp_stack:
        stack.append(temp_stack.pop())

for x in stack:
    print(x, end="")
