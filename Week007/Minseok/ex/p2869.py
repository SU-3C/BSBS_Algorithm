# 2869 [s5] 달팽이는 올라가고 싶다

up, down, height = map(int, input().split())

''' 시간 오버 코드
now = 0
day = 0

while True:
    now += a
    day += 1

    if now >= v:
        print(day)
        break
    now -= b
'''

# print(f'{q}')

q = (height-up) // (up - down)
if height <= up:
    print(1)
elif (height - up) == q * (up - down):
    print(q + 1)
else:
    print(q + 2)