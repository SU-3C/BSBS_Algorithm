# 17608 [b2] 막대기

import sys

stick = [int(sys.stdin.readline()) for x in range(int(sys.stdin.readline()))]

max_stick = stick.pop()
# 마지막 입력

cnt = 1
# 최소 하나 이상의 막대

for x in reversed(stick):
    if x > max_stick: # 마지막 막대보다 키가 큰 막대가 있다면
        max_stick = x # 값을 대입하고 카운트를 증가
        cnt += 1
        
print(cnt)