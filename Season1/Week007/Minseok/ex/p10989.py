# 10989 [b1] 수 정렬하기 3

import sys

_ = sys.stdin.readline()

dic = {}
for a in range(int(_)):
    x = int(sys.stdin.readline())
    if x in dic:
        dic[x] = dic[x] + 1
    else:
        dic[x] = 1

for k in sorted(dic.keys()):
    for x in range(dic.get(k)):
        print(k)

