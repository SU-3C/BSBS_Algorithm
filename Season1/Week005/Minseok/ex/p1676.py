# 1676 [s5] 팩토리얼 0의 개수

result = 1
for x in range(2, int(input())+1):
    result *= x

print(abs(len(str(result))-len(str(int(str(result)[::-1])))))