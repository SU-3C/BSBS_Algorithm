# 2869 [s5] 달팽이는 올라가고 싶다

a, b, v = map(int, input().split())

# a UP b down V height
        # 마지막날 # 하루당
result = (v-a) / (a-b) + 1

print(result)