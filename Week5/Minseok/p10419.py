# 10419 [b3] 지각

# 해당 알고리즘 S = T^2 + T
from math import *  # math 안의 함수를 import 하라는 의미
                    # math.sqrt() 대신 sqrt()를 사용할 수 있다.

for x in range(0, int(input())):    # 입력받은 값 만큼 반복문 실행
    time = int(input())
    if time == 1:   # 1일때를 제외하고는 0이 나올수 없으므로 예외처리
        print(0)
        continue

    num =  int(sqrt(time))  # 제곱근을 구하고 소숫점을 버림

    if pow(num, 2) + num <= time:   # num ^ 2 + num이 수업시간보다 작거나 같으면 num을 출력
        print(num)
    else:   # 아닐 경우 1을 빼서 출력
        print(num - 1)
