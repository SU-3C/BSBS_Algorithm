# 4153 [b3] 직각삼각형

while True:
    arr = list(map(int, input().split()))
    if sum(arr) == 0: # 만약 0, 0, 0이 입력될 경우 종료
        break
    arr.sort() # 길이 순서대로 정렬
    print("right" if arr[0]**2 + arr[1]**2 == arr[2]**2 else "wrong")
    # 삼향 연산자 (True일때출력할값 if 조건문 else False일때 출력할 값)
    # 작은 변의 제곱의 합이 큰 변의 제곱의 합과 같다면 right 출력
