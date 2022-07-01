# 1935 [s3] 후위 표기식2

_, i, *arr = open(0)

cnt = 0
stack = []

for x in i.rstrip():
    # print(f'cmd: {x}')
    if x in "+-*/":
        a = stack.pop()
        b = stack.pop()
        if type(a) == str and not a.isdigit():
            a = arr[ord(a)-65].strip()
        if type(b) == str and not b.isdigit():
            b = arr[ord(b)-65].strip()
        r = eval(f'{b}{x}{a}')
        stack.append(r)
    else:
        stack.append(x)
        cnt += 1   

print(f'{stack[0]:.2f}')

'''
for x in i.strip():
    if x in "+-*/":
        a = stack.pop()
        b = stack.pop()
        # if type(a) == str and not a.isdigit():
        #     a = arr[cnt].strip()
        # if type(b) == str and not b.isdigit():
        #     b = arr[cnt-1].strip()
        print(f'{b}{x}{a}')
        r = eval(f'{b}{x}{a}')
        stack.append(r)
    else:
        stack.append(int(arr[cnt]))
        cnt += 1

print(f'{stack[0]:.2f}')
'''

