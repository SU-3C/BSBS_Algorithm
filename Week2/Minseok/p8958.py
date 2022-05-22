# 8958 [b2] OX퀴즈

for x in range(0, int(input())):
    string = input()
    cnt = sumValue = 0
    for y in string:
        if y=="X":
            cnt = 0
            continue
        cnt = cnt + 1
        sumValue = sumValue + cnt
    print(sumValue)
