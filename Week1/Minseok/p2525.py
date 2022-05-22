# 2525 [b4] 오븐 시계

a, b = map(int, input().split())
b = b + int(input())

a = (a + b // 60) % 24
b = b % 60

print(a, b)