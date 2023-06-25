# 2480 [b4] 주사위 세개

a,b,c = map(int, input().split())
ans = 0
if len(set([a,b,c])) == 1:
    ans = 10000 + a*1000
elif len(set([a,b,c])) == 3:
    ans = 100*max([a, b, c])
else:
    if a==b or b==c:
        ans = 1000 + b * 100
    else:
        ans = 1000 + a * 100
print(ans)