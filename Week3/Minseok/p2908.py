# 2908 [b2] 상수

a, b = map(int, input()[::-1].split()) # 문자열 전체 뒤집고 a, b에 나눠 저장
print(max(a, b)) # 큰 수 출력