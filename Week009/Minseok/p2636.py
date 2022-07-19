# 2636 [g4] 치즈

import sys
input = sys.stdin.readline

a, b = map(int, input().split())

cheese = [sys.stdin.readline().rstrip() for x in range(a)]
tu = [(0, -1), (-1, 0), (1, 0), (0, 1)]

