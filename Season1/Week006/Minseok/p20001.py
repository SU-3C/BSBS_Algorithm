# 20001 [b1] 고무오리 디버깅

n_list = ["고무오리 디버깅 시작", "고무오리 디버깅 끝", "고무오리", "문제", "고무오리야 사랑해", "힝구"]

input() # 첫 입력은 고정

solved = 0 # 0 문제 시작

while True:
    x = input()
    if x == n_list[1]: # 디버깅 끝
        break
    if x == n_list[2]: # 고무오리 : 문제 해결, 0 문제면 +2 문제
        if solved == 0:
            solved += 2
            continue
        solved -= 1
    if x == n_list[3]: # 문제 : 1문제 증가
        solved += 1
        
print(n_list[4] if solved == 0 else n_list[5])
