# 2839 [b1] 설탕 배달


i = int(input())

if i in [4, 7]:
    print(-1)
    quit()

five = i // 5
three = i % 5

if three %3 == 0:
    print(five + three//3)
    quit()

for _ in range(1, i//3+2):
    five = five - 1
    if (three + _*5) % 3 == 0:
        print(five + (three + 5 * _)//3)
        quit()
