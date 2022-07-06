# 4949 [s4] 균형잡힌 세상

import sys

while (s:= sys.stdin.readline().rstrip()) != ".":
    # 바다코끼리 연산자 : s에 값을 대입해 조건문을 비교한 후 아래에서 사용이 가능함
    stack = []  # 스택 선언
    res = True # 균형잡힌 문자열 여부
    for x in s:
        if x == "(":    # (, [ 인 경우 스택에 추가
            stack.append('(')
        elif x == "[":
            stack.append('[')
        elif x == ")":  # ), ] 인 경우 짝을 확인
            if len(stack) != 0 and stack[-1] == "(":
                stack.pop() # 짝이 맞을 경우 pop
            else:
                res = False # 짝이 맞지 않으면 균형잡힌 문자열이 아님
                break
        elif x == "]":
            if len(stack) != 0 and stack[-1] == "[":
                stack.pop()
            else:
                res = False
                break
        if x == ".":
            break

    if len(stack) != 0: # 종료되었지만 스택에 남아있다면
        res = False     # 균형잡힌 문자열이 아님
    print("yes" if res else "no")