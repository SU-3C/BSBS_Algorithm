# 1085 [b3] 직사각형에서 탈출

x, y, w, h = map(int, input().split())
print(min(x, y, w-x, h-y))

# x, y 좌표와 width, height 값을 입력 받았을때
# 직사각형의 4개의 좌표는

# (0, height)	(width, height)
#
# 		현재위치(x, y)
#
# (0, 0)		(width, 0)

# 현재 위치인 (x, y)에서 가장 가까운 모서리로 이동하여
# 탈출한다면 필요한 값은 min (0-x, 0-y, w-x, h-y)

