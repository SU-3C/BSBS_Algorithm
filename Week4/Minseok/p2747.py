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