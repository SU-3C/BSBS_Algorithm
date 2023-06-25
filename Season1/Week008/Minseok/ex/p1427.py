# 1427 [s5] 소트인사이드

ar = {}

for x in input():
    if x in ar:
        ar[x] = ar[x] + 1
    else:
        ar[x] = 1

for x in sorted(ar.keys(), reverse=True):
    print(x * ar[x], end="")

