# 11650 [s5] 좌표 정렬하기

_, *arr = open(0)

res = []
for x in arr:
    a, b = map(int, x.split())
    res.append((a, b))

res.sort()

for x, y in res:
    print(x, y)


''' 틀린코드
for x in arr:
    a, b = map(int, x.split())
    if q.get(a):
        q.update({a:q.get(a) + [b]})
    else:
        q[a] = [b]

for k, v in q.items():
    v.sort()
    for i in v:
        print(f'{k} {i}')
'''
