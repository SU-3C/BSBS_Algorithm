# 1966 [s3] 프린터 큐

from collections import deque

i = input() # 테스트 케이스 I

for x in range(int(i)):
    N, M = map(int, input().split())
    # N 문서의 개수, M 번째 문서
    arr = deque(map(int, input().split()))
    cnt = 0
    now = M # M번째 문서를 추적
    while arr:
        t = arr.popleft()
        now -= 1 # 한칸씩 앞당겨진 관계로 -1

        # print(f'{arr}/ t:{t} cnt:{cnt} now:{now}')
        # 배열 내용 arr, 현재 문서 t, 인쇄 횟수 cnt, 현재 M번째 문서의 위치 now
        # 를 추적하기 위해 만든 print 문

        if not arr:
            cnt += 1
            # pop을 했더니 arr가 없으니 출력횟수에 1을 추가, 종료
            break
        if max(arr) > t:
            # 중요도가 가장 높지 않을 때
            if now == -1: # 추적중인 문서의 위치를 가장 뒤로 이동
                now = now + len(arr) + 1
            arr.append(t) # 현재 문서를 가장 뒤로 배치
        else: # 이번 문서의 중요도가 가장 높을 경우
            cnt += 1
            if now == -1: # 이번 문서가 추적 중인 문서라면
                break # 출력이 완료되었으니 종료

    print(cnt)

