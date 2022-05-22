# 2621 [s4] 카드게임 - 푸는 중

arr = [input().split() for x in range(0, 5)]
color = []
number = []

result = 0

for x, y in arr:
    color.append(x)
    number.append(int(y))

color.sort()
number.sort()

sColor = set(color)
sNumber = set(number)

print(color, number)
print("%", len(sColor), len(sNumber))

if len(sColor) == 1:
    print("flush")
    if result < 600:
        result = 600 + number[4] # Flush

if len(sNumber) == 5:
    if number[0] == number[4] - 4:
        print("straight")   
        result = 500 + number[4]    # Straight
        if sColor == 0:
            print('straight flush')
            result = 900 + number[4]    # Straight Flush
            quit()
    else:
        print(f'{number[4]} top')
        result = 100 + number[4]    # TOP

if len(sNumber) == 2:
    if number[1] == number[2]:
        print("full house")
    else:
        print(f"{number[2]} four card")

if len(sNumber) == 3:   # two pair / triple
    print(f"{number[2]} triple card")

if len(sNumber) == 4:   # One Pair
    t = a
    for i in set(t):
        t.remove(i)
    print(f"{t[0]} One Pair")
    

print(result)

