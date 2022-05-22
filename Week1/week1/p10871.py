# 10871 [b3] X보다 작은 수

a, b = map(int, input().split())
ar = [int(x) for x in input().split()]

for x in ar:
    if x<b:
        print(x, end=" ")