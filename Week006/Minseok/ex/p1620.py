# 1620 [s4] 나는야 포켓몬 마스터

import sys

d, s = map(int, input().split())
dic = {sys.stdin.readline().rstrip():i for i in range(1, d+1)}

for x in range(s):
    sol = sys.stdin.readline().strip()
    if sol.isdigit():
        print(dic[int(sol)-1])
    else:
        print(dic.index(sol) + 1)
