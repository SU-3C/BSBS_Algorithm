# 1009 [s2] 분산처리

for _ in range(int(input())):
    a, b = map(int, input().split())
    res = int(a)
    pc = [[0], [1], [2, 4, 8, 6], [3, 9, 7, 1], [4, 6], [5], [6], [7, 9, 3, 1], [8,4,2,6], [9,1]]
    
    a = a % 10
    p = (b-1) % len(pc[a])

    # print(f'{a} {b} {p} {pc[a][p]} {pc[a]}')

    print(pc[a][p] if pc[a][p] != 0 else "10")

