# 17413 [s3] 단어 뒤집기 2

import sys
from collections import deque

string = deque(sys.stdin.readline().rstrip())

stack = deque()
# 출력용 스택
temp_stack = deque()
# 임시용 스택

while string:
    a = string.popleft()
    if a == "<": # < 일 경우
        if temp_stack: # temp_stack이 비어있지않다면 
            while temp_stack: # temp_stack이 빌때까지 역순으로 출력에 저장
                stack.append(temp_stack.pop())

        stack.append(a) # 정순으로 출력에 저장
        while True:
            b = string.popleft()
            stack.append(b)
            if b == ">":    # >가 나올때까지 출력에 저장
                break
    else:   # 아닐 경우
        if a == " ":    # 띄어쓰기가 나왔다면
            if temp_stack:  # temp_stack이 빌때까지 역순으로 출력에 저장
                while temp_stack:
                    stack.append(temp_stack.pop())
            stack.append(a) # 띄어쓰기를 출력에 저장
        else:
            temp_stack.append(a) # 역순으로 뒤집기 위해 temp_stack에 저장 

if temp_stack:  # 만약 남아있을 경우
    while temp_stack:   # temp_stack이 빌때까지 역순으로 저장
        stack.append(temp_stack.pop())

for x in stack: # 출력용 stack에 저장된 순서대로 출력
    print(x, end="")
