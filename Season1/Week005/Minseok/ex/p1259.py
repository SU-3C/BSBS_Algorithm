# 1259 [b1] 펠린드롬수

while True:
    res = input()
    if res == "0":
        break
    print("yes" if res == res[::-1] else "no")

