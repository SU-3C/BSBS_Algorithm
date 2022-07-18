# 11943 [b4] 파일 옮기기

a, b = map(int, input().split())
c, d = map(int, input().split())

q = a + d
w = b + c

print(min(q, w))