# 1453 [b2] 피시방 알바

a = []
cnt = 0
input()

for x in map(int, input().split()):
    if not x in a:
        a.append(x)
    else:
        cnt += 1

print(cnt)