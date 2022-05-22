# 14681 [b4] 사분면 고르기

a, b = map(int, [input(), input()])

ar = [[1,4],[2,3]]
ax = (0 if a > 0 else 1)
bx = (0 if b > 0 else 1)

print("%d" % ar[ax][bx])

# 1 사분면 (1, 1) 00 -> 3 / 0 = 0 0
# 2 사분면 (0, 1) 10 -> 1 / 1 = 0 1
# 3 사분면 (0, 0) 11 -> 0 / 2 = 1 0
# 4 사분면 (1, 0) 01 -> 2 / 3 = 1 1

'''
qua = 0 # 0b0   

if a > 0:
    qua = 4
    if b > 0:
        qua = qua - 3
    else:
        qua = qua - 0
else:
    qua = 3
    if b > 0:
        qua = qua - 1
    else:
        qua = qua - 0

print("%d" % qua)
'''