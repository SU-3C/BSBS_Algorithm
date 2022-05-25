# 2675 [b2] 문자열 반복

for x in range(0, int(input())):
    a, b = input().split()
    for y in b:
        print(y*int(a),end="")
    print()