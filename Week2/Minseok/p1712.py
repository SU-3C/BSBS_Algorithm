# 1712 [b4] 손익분기점

# 구 버전 코드

a, b, c = map(int, input().split())

if b>=c:
    print('-1')
else:
    print( a//(c-b) +1 )