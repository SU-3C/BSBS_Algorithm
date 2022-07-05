# 10799 [s3] 쇠막대기

stack = []
# 스택 선언

count = 0
# 쇠 막대의 수

inp = input().replace("()", "*")
# 자르는 위치를 *로 대체

for x in inp:
    if x == "(": # 쇠막대가 시작될 경우 스택에 추가
        stack.append("(")
    elif x == "*":  # 스택에 있는 쇠막대기의 수만큼 더하기
        count += len(stack)
    else:   # 쇠막대의 끝에 도달하였기 때문에 pop
        stack.pop()
        count += 1

print(count)