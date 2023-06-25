# 1918 [g2] 후위 표기식

string = input()
stack = []
operstack = []

for x in string:
    # print(stack)
    # print(operstack)
    if x == "(":
        operstack.append(x)
    elif x == ")":
        while operstack and operstack[-1] != "(":
            a = stack.pop()
            b = stack.pop()
            oper = operstack.pop()
            r = f'{b}{a}{oper}'
            stack.append(r)
        operstack.pop()

    elif x in "+-*/":
        # print(f'oper: {x}')
        if not operstack or operstack[-1] == "(":
            operstack.append(x)
            continue
        if x in "*/":
            oper = operstack[-1]
            if oper in "+-":
                operstack.append(x)
            else:
                a = stack.pop()
                b = stack.pop()
                oper = operstack.pop()
                r = f'{b}{a}{oper}'
                stack.append(r)
                operstack.append(x)
        elif x in "+-":
            while operstack and operstack[-1] != "(":
                a = stack.pop()
                b = stack.pop()
                oper = operstack.pop()
                r = f'{b}{a}{oper}'
                stack.append(r)
                # print(f'{stack}')
            operstack.append(x)
        else:
            operstack.append(x)
    else:
        stack.append(x)
        # print(stack)

# print(stack)
# print(operstack)

while operstack:
    a = stack.pop()
    b = stack.pop()
    oper = operstack.pop()
    r = f'{b}{a}{oper}'
    stack.append(r)
    # print(stack)

print(stack.pop())

