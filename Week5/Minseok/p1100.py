# 1100 [b2] 하얀 칸

chess = [input() for x in range(0, 8)]
# 체스판 입력 받기

result = 0 # 출력할 값

odd = False  # N번 출력

for x in chess:
    result += x[odd::2].count("F")  # odd의 위치부터 시작해 2개씩 건너뛰며 F의 갯수를 셈
    odd = not odd # 1일 경우 0, 0일 경우 1을 저장

print(result)

print()