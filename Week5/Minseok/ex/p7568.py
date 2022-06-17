# 7568 [s5] 덩치

arr = [(input().split()) for x in range(int(input()))]
rank = [0] * len(arr)

for i, x in enumerate(arr):
    a, b = x
    for y in arr:
        c, d = y
        if int(a) < int(c) and int(b) < int(d):
            rank[i] = rank[i] + 1

for _ in rank:
    print(_+1)
