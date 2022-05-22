# 10991 [b3] 별 찍기 - 16

_ = int(input())
for x in range(0, _):
    print(" "*((_-1//2)-x-1),end="")
    for y in range(0, x+1):
        print("*", end=" ")
    print()