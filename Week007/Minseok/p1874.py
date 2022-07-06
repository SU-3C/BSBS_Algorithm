# 1874 [s2] 스택 수열

import sys
from collections import deque
# 덱은 queue 중 좌 우로 push, pop이 가능한 자료구조

i = sys.stdin.readline()
# 수열의 길이

arr = deque()
for x in range(int(i)):
    arr.append(int(sys.stdin.readline()))
# 만들어야 하는 수열 저장

nums = deque([x for x in range(int(i), 0, -1)])
# 수열의 길이에 해당하는 덱 생성 (8, 7, 6, ...., 2, 1)

stack = deque()
# 연산용 스택
result = deque()
# 출력을 저장할 덱

flag = True # 수열 만들수 있는지 여부

while len(arr) > 0:
    x = nums[-1] if nums else int(i)+1
    # 만약 nums가 비어있지 않다면 가장 마지막 요소를 가져오고
    # 비어있다면 수열의 길이 + 1을 가져와 에러처리

    # print(f'x: {x}, arr[0]: {arr[0]}, stk_top: {stack[-1] if stack else ""}')

    if x < arr[0]: # 만들 수열보다 작을 경우 
        stack.append(x) # 스택에 추가
        result.append("+") # 출력결과에 +를 저장
        nums.pop() 
        continue
    elif x == arr[0]: # 값이 맞을 경우
        result.append("+") # 넣었다가
        result.append("-") # 빼기
        nums.pop()
        arr.popleft()
        continue
    elif stack and arr[0] == stack[len(stack)-1]:
        stack.pop() # stack이 비어있지않으며, 스택의 top이 출력이 필요할 경우
        arr.popleft()   # 만들 수열의 0번을 pop
        result.append("-")  # - 출력을 저장
        continue
    flag = False    # 만약 위 분기에 들어가지 못하였다면
                    # 불가능한 경우이므로 break
    break

if flag:    # 성공했을 경우 순서대로 출력
    for x in result:
        print(x)
else:       # 아닐 경우 NO 출력
    print("NO")