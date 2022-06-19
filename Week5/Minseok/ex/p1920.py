# 1920 [s4] 수 찾기

input()
table = set(map(int, input().split()))
input()
find = map(int, input().split())

for x in find:
    if x in table:
        print(1)
    else:
        print(0)
