# 2577 [b2] 숫자의 개수

a,b,c = map(int, (input(), input(), input()))
for x in range(0, 10):
    print(str(a*b*c).count(str(x)))
