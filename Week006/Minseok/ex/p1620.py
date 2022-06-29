# 1620 [s4] 나는야 포켓몬 마스터

import sys

d, s = map(int, input().split())

dic_s = []
dic = {}

for x in range(1, d+1):
    string = sys.stdin.readline().rstrip()
    dic_s.append(string)
    dic[string] = x

print(dic_s)
print(dic)

for x in range(s):
    sol = sys.stdin.readline().strip()
    if sol.isdigit():
        print(dic_s[int(sol)-1])
    else:
        print(dic.get(sol))
