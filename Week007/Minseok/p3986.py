# 3986 [s4] 좋은 단어

from collections import deque

_, *a = open(0)
result = 0
for x in a:
    stack = deque()
    for y in x.strip():
        # print(f'{stack[-1] if stack else ""} {y} {(stack[-1] if stack else "") == y}')
        if stack and stack[-1] == y:
            stack.pop()
        else:
            stack.append(y)
    if not stack:
        result += 1

print(result)
