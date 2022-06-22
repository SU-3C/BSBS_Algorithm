# 2609 [b1] 최대공약수와 최소공배수

a, b = map(int, input().split())

for x in range(abs(b-a), 0, -1):
    if a % x == 0 and b % x == 0:
        print(x)
        break

if a == b:
    print(a)

xcnt = 1

while(True):
    if a * xcnt % b == 0:
        print(a*xcnt)
        break
    xcnt = xcnt + 1
