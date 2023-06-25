# 1934 [b1] 최소공배수

for x in range(int(input())):
    a, b = map(int, input().split())
    mx = max(a, b)
    mn = min(a, b)
    if mx % mn == 0:
        print(mx)
        continue
    arr = []
    i = 2
    ta, tb  = a, b
    while i <= mx - mn and i <= mx:
        if ta % i == 0 and tb % i == 0:
            ta /= i
            tb /= i
            arr.append(i)
        else:
            i += 1

    # print(f'{ta} {tb} {arr}')
    result = ta * tb
    for y in arr:
        result *= y

    print(int(result))