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

result = 0

for x, y in arr:    
    color.append(x) # color 배열에 색만 저장
    num = int(y)    # string을 int로 변환
    number.update({num: int(number.get(num) or 0) + 1}) # number라는 사전에 num의 값을 조회해 +1을 해 저장
                                    #  int(number.get(num) or 0) number.get이라는 값이 None이라면 0을 반환 

num_set = list(set(number.keys()))  # set은 중복을 허용하지 않는 특징을 가짐
num_array = tuple(sorted(list(number.values()), reverse=True))  
        # number.values() number의 value에 해당 하는 값을 모두 가져옴
        # list형으로 캐스팅, sorted reveser=True를 통해 역순으로 만든 후 Tuple형으로 캐스팅
flush = (True if len(set(color)) == 1 else False)
    # set을 통해 중복을 허용하지 않은 집합을 만들고 len을 통해 길이를 가져옴
    # 1일 경우 모두 한종류의 색상이 입력됬다는 것을 의미 -> True

### [k for k in number if number[k] == 4] value가 4인 모든 key를 가져옴

if find_table[0] == num_array:      # (4, 1) 포카드
    result = 800 + [k for k in number if number[k] == 4][-1]

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
    
print(result)

