# 2231 [b2] 분해 합

i = int(input())
leng = len(str(i))

success = False
for x in range(i-leng*10, i):
    if x < 1:
        continue
    res = x
    for y in str(x):
        res += int(y)
    if res == i:
        print(x)
        success = True
        break

if not success:
    print(0)