# 1158 [s4] 요세푸스 문제

from collections import deque

N, K = map(int, input().split())
arr = deque([x for x in range(1, N+1)])

result = []
cnt = 0
while arr:
    cnt += 1
    if cnt % K == 0:
        result.append(str(arr.popleft()))
    else:
        arr.append(arr.popleft())

print(f'<{", ".join(result)}>')
