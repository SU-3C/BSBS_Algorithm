# 1874 [s2] 스택 수열

import sys
from collections import deque

i = sys.stdin.readline()
arr = deque()
for x in range(int(i)):
    arr.append(int(sys.stdin.readline()))

nums = deque([x for x in range(int(i), 0, -1)])
stack = deque()

result = deque()
flag = True
while len(arr) > 0:
    x = nums[-1] if nums else int(i)+1
    print(f'x: {x}, arr[0]: {arr[0]}, stk_top: {stack[-1] if stack else ""}')
    if x < arr[0]:
        stack.append(x)
        result.append("+")
        nums.pop()
        continue
    elif x == arr[0]:
        result.append("+")
        result.append("-")
        nums.pop()
        arr.popleft()
        continue
    elif stack and arr[0] == stack[len(stack)-1]:
        stack.pop()
        arr.popleft()
        result.append("-")
        continue
    flag = False
    break

if flag:
    for x in result:
        print(x)
else:
    print("NO")