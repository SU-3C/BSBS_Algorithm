# 2675 [b2] 문자열 반복

for x in range(0, int(input())):
    a, b = input().split()
    for y in b:
        print(y*int(a),end="")
    print()

# String * int는 해당 String을 Int 만큼 반복