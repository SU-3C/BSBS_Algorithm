# 10773 [s4] 제로

import sys

cmd = [int(sys.stdin.readline()) for x in range(int(sys.stdin.readline()))]
# 정수들의 입력

temp = []
for x in cmd:
    if x == 0: # 0 이면 마지막 수 취소
        temp.pop()
        continue
    temp.append(x)  # 아니면 추가
    
print(sum(temp))
