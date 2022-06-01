# 4619 [b3] 루트

# 양의 정수 B N
# B에 가장 가까운 정수 A^N의 정수 A
# 1 ≤ B ≤ 1,000,000
# 1 ≤ N ≤ 9

while True:
    B, N = map(int, input().split())
    if B == N == 0: # 0 0 일 경우 탈출
        break
    last = 0
    start = 1
    while True:
        root = pow(start, N)
        if root > B:                # 만약 start^N이 B를 넘을 경우 
            if root - B > B - last: # 이번 제곱수에서 주어진 값을 뺀 결과가
                                    # 주어진 값에서 저번 결과를 뺀 값보다 크면
                print(start - 1)    # 이전 index를 출력
            else:
                print(start)    # 아닐 경우 해당 index를 출력
            break
        last = root # 마지막 연산값을 last에 저장
        start = start + 1

