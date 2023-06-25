# 1935 [s3] 후위 표기식2

_, i, *arr = open(0)
# 첫줄은 _, 두번째 줄은 i, 나머지 줄은 arr에 배열로 저장

cnt = 0
stack = []

for x in i.rstrip():
    # print(f'cmd: {x}')
    if x in "+-*/": # 연산자인 경우
        a = stack.pop() # 저장되어있는 두개의 피연산자를 꺼내온다
        b = stack.pop()
        if type(a) == str and not a.isdigit():  # 피연산자가 알파벳일 경우
            a = arr[ord(a)-65].strip()  # 배열에서 값을 꺼내 'A'-65 로 0~25번
        if type(b) == str and not b.isdigit(): # 값을 가져와 변수에 저장
            b = arr[ord(b)-65].strip()
        r = eval(f'{b}{x}{a}')  # 피연산자 연산자 피연산자 스트링을 실행
                        # ex) '1+2' 라는 텍스트가 있을 경우 3을 반환
        stack.append(r) # 결과를 저장
    else:   # 만약 연산자가 아니라면 스택에 저장
        stack.append(x)
        cnt += 1 # 사용X

print(f'{stack[0]:.2f}')     # 결과를 소숫점 두자리까지 출력


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

