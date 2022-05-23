# 2839 [b1] 설탕 배달


i = int(input())

if i in [4, 7]: # 4와 7일 경우에는 무슨수를 써도 맞출 수 없음
    print(-1)
    quit()

five = i // 5   # 우선 5kg짜리 포대를 최대한 사용
three = i % 5   # 남은 양을 변수에 저장

if three %3 == 0:   # 만약 변수를 3으로 나눴을때 0이면 그대로 출력
    print(five + three//3)
    quit()

for _ in range(1, i//3+2):  
    five = five - 1 # 5kg 포대를 하나씩 줄여서
    if (three + _*5) % 3 == 0:  # 3kg 포대가 나눠 떨어질떄까지 연산
        print(five + (three + 5 * _)//3)    # 나누어 떨어지면 출력 후 종료
        quit()
