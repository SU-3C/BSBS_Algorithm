import sys
input = sys.stdin.readline

height = int(input())
steps = [int(input()) for x in range(0, height)]

#print(steps)

cont = []
n_cont = []

if height < 3: # 3 이하 특수 예외처리
    if height == 1:
        print(steps[0])
    elif height == 2:
        print(steps[0] + steps[1])

else: # 점화식 전처리
    cont.append(steps[0])
    cont.append(steps[0] + steps[1])
    cont.append(steps[1] + steps[2])
    
    n_cont.append(steps[0])
    n_cont.append(steps[1])
    n_cont.append(steps[0] + steps[2])

    for x in range(3, height):
        #print(f'{steps[x]}')
        cont.append(n_cont[x-1] + steps[x])
        
        t = max(n_cont[x-2], cont[x-2]) + steps[x]
        n_cont.append(t)
    
    # print(f'con {cont}')
    # print(f'ncn {n_cont}')
    
    print(max(cont[-1], n_cont[-1]))