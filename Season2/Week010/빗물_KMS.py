import sys

input = sys.stdin.readline

h,w = map(int, input().split())
blocks = list(map(int, input().split()))

boxs = [[0 for x in range(0, w)] for x in range(0, h)]

for x in range(w-1, -1, -1):
	t = blocks.pop()
	for y in range(h-t, h):
		boxs[y][x] = 1

result = 0
for y in range(h-1, -1, -1):
	if boxs[y].count(1) < 2:
		break
	l, r = boxs[y].index(1), w - boxs[y][::-1].index(1) - 1
	result = result + (r - l - 1 - boxs[y][l+1:r].count(1))

print(result)