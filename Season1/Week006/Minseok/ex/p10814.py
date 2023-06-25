# 10814 [s5] 나이 순 정렬하기

_, *arr = open(0)

dic = []

for x in arr:
    a, b = x.split()
    dic.append((int(a), b))

dic.sort(key=lambda x: x[0])

for x, y in dic:
    print(f'{x} {y}')