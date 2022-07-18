# 1373 [b1] 2진수 8진수

import sys

i = input()[::-1]

stack = []

for x in range(0, int((len(i)+ 2) // 3)):
    t = int(i[x*3:x*3+3][::-1], 2)
    stack.append(f'{t}')

while stack:
    print(stack.pop(), end="")

