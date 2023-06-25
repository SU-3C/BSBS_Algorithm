# 11050 [b1] 이항계수 1

# 이항계수가 먼데
# https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=junhyuk7272&logNo=222053814549

fact = [1]

N, K = map(int, input().split())

for x in range(0, N):
    fact.append(fact[x] * (x+1))

print(int(fact[N] / (fact[K] * fact[N-K])))