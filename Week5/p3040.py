# 3040 [b2] 백설 공주와 일곱 난쟁이

nine = [int(input()) for x in range(0, 9)]  # 입력받기

sumNine = sum(nine) - 100   # 7 값의 합이 100

for x in nine:
    if sumNine - x == x: continue   # 자기자신을 뺀 값이 정답일 수는 없으니 예외처리
    if nine.count(sumNine - x) == 1:    # 두 값의 합이 100과의 차이와 같다면
        nine.remove(sumNine - x)    # 두 값을 배열에서 제거
        nine.remove(x)
        break

for x in nine:  # 남은 배열을 순서대로 출력
    print(x)

# 스폐셜 저지라 출력 순서 상관없이 답만 맞을 경우 정답처리
# 오류 케이스도 정답으로 처리하는 케이스부족 경우도 존재