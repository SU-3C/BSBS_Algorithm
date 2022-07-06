# 3986 [s4] 좋은 단어

from collections import deque

_, *a = open(0)
result = 0
# 좋은 단어 갯수
for x in a:
    stack = deque()
    for y in x.strip():
        # print(f'{stack[-1] if stack else ""} {y} {(stack[-1] if stack else "") == y}')
        if stack and stack[-1] == y:
            # 스택이 비어있지 않으며 스택의 top과 값이 같으면 pop
            stack.pop()
        else:   # 비어있거나 다를 경우 스택에 push
            stack.append(y)
    if not stack:   # 결과 스택이 비어있다면 좋은 단어
        result += 1 # 비어있지 않다면 좋은 단어가 아님.

print(result)
