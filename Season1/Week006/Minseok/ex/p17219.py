# 17219 [s4] 비밀번호 찾기

import sys

s, f = map(int, input().split())

save = {}

for x in range(s):
    save_str = sys.stdin.readline().split()
    save[save_str[0]] = save_str[1]

# [sys.stdin.readline().split() for x in range(s)]

find = [sys.stdin.readline().strip() for x in range(f)]

for x in find:
    print(save[x])


