# 1018 [s4] 체스판 다시 칠하기

import sys

h, w = map(int, input().split())

board = [sys.stdin.readline().strip() for x in range(h)]

temp = ""

count_array = []

for x in range(0, w-7):
    for y in range(0, h-7):
        b_count = 0
        w_count = 0

        temp = ".".join([board[z][x:x+8] for z in range(0+y, 8+y)])

        b_count += temp[::2].count('W')
        b_count += temp[1::2].count('B')
        w_count += temp[::2].count('B')
        w_count += temp[1::2].count('W')

        # print(f'{x+8}/{y+8} {temp}, {b_count} {w_count}')

        count_array.append(min(b_count, w_count))

print(min(count_array))