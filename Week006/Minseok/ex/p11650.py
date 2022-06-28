# 11650 [s5] 좌표 정렬하기


_, *arr = open(0)

res = []
for x in arr:
    a, b = map(int, x.split())
    res.append((a, b))


res.sort()

for x, y in res:
    print(x, y)

''' 시간 초과
_, *arr = open(0)

q = {}
for x in arr:
    a, b = map(int, x.split())
    if q.get(a):
        q.update({a:q.get(a) + [b]})
    else:
        q[a] = [b]

for k, v in sorted(q.items()):
    v.sort()
    for i in v:
        print(f'{k} {i}')
''' 
