# 2920 [b2] 음계

res = ["ascending", "descending", "mixed"]

a, b, c, d, e, f, g, h = map(int, input().split())

if a < b < c < d < e < f < g < h:
	print(res[0])
elif h < g < f < e < d < c < b < a:
	print(res[1])
else:
	print(res[2])

''' # 옛날에 풀었던거
def _(m):
    if m == sorted(m):
        print("as" + p)
    elif m == list(reversed(sorted(m))):
        print("des" + p)
    else:
        print("mixed")

p = "cending"
_(list(map(int, input().split())))
'''