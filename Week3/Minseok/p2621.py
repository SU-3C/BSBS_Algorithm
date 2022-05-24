# 2621 [s4] 카드게임

arr = [input().split() for x in range(0, 5)]

find_table = [
  ((4, 1)),   # 포카드
  ((3, 2)),   # 풀하우스
  ((3,1,1)),  # 트리플
  ((2,2,1)),  # 투페어
  ((2,1,1,1)),# 원페어
  ((1,1,1,1,1)) # 탑 or 스트레이트
]

color = []
number = {}

def _(i):
    return [k for k in number if number[k] == i]

result = 0

for x, y in arr:
    color.append(x)
    num = int(y)
    number.update({num: int(number.get(num) or 0) + 1})

num_set = list(set(number.keys()))
num_array = tuple(sorted(list(number.values()), reverse=True))
flush = (True if len(set(color)) == 1 else False)


# [k for k in number if number[k] == 4] value가 4인 모든 key를 가져옴

if find_table[0] == num_array:      # (4, 1) 포카드
#    result = 800 + [k for k in number if number[k] == 4][-1]
    result = 800 + _(4)[-1]

elif find_table[1] == num_array:    # (3, 2)    풀하우스
    result = 700 + [k for k in number if number[k] == 3][-1] * 10 + [k for k in number if number[k] == 2][-1]

elif find_table[2] == num_array:    # (3, 1, 1) 트리플
    result = 400 + [k for k in number if number[k] == 3][-1]

elif find_table[3] == num_array:    # (2, 2, 1) 투페어
    pair = [k for k in number if number[k] == 2]
    pair.sort()
    result = 300 + pair[1] * 10 + pair[0]

elif find_table[4] == num_array:    # (2, 1, 1, 1) 원페어
    result = 200 + [k for k in number if number[k] == 2][-1]

elif find_table[5] == num_array:    # (1, 1, 1, 1, 1) 스트레이트 or TOP
    temp_list = num_set
    if temp_list[0] + 4 == temp_list[4]:    # 첫번째와 마지막 차이가 4면 스트레이트
        result = 500 + temp_list[4]
    else:                                   # 아닐 경우 TOP
        result = 100 + max(num_set)

if flush:   # Color가 하나일 경우
    if result // 100 == 5:  # 스트레이트였다면 스트레이트 플러쉬
        result = result + 400
    else:       # 포카드나 풀 하우스일 경우 플러쉬보다 점수가 높음
        if result < 600:    # result가 600보다 적을 경우에만
            result = 600 + max(num_set)
    
# print(flush)
print(result)

