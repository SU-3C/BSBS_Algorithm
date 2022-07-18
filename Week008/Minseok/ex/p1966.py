# 1966 [s3] 프린터 큐

from collections import deque

i = input()

for x in range(int(i)):
    N, M = map(int, input().split())
    # N 문서의 개수, M번째 문서
    arr = deque(map(int, input().split()))
    cnt = 0
    now = M
    while arr:
        t = arr.popleft()
        now -= 1

        #print(f'{arr}/ t:{t} cnt:{cnt} now:{now}')
        if not arr:
            cnt += 1
            break
        if max(arr) > t:
            if now == -1:
                now = now + len(arr) + 1
            arr.append(t)
        else:
            cnt += 1
            if now == -1:
                break

    print(cnt)

