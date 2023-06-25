# 2747 [b3] 피보나치 

fibo = [0, 1]
resIndex = int(input())
if resIndex < 2:
    print(fibo[resIndex])
    quit()
for x in range(1, resIndex):
    fibo.append(fibo[x]+fibo[x-1])
    
# for x, i in enumerate(fibo):
#     print(i, x)
print(fibo[resIndex])

# 피보나치 동적계획법
# 재귀함수를 통해 계속 계산하는 것이 아닌
# 계산한 값을 미리 저장해두고 꺼내오는 방식