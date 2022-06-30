# 10799 [s3] 쇠막대기

stack = []

count = 0

inp = input().replace("()", "*")

for x in inp:
    if x == "(":
        stack.append("(")
    elif x == "*":
        count += len(stack)
    else:
        stack.pop()
        count += 1

print(count)