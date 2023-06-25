# 2562 [b2] 최댓값

a = [int(input()) for x in range(0, 9)]
# [(실행할 함수) for x in range(0, 9)]
# for x in range(0, 9)가 루프를 돌때마다 앞에있는 함수가 실행됨

print(max(a), a.index(max(a))+1)
# 모두 다른 수라는 조건이 있기때문에
# max(a)를 통해 최댓값, a.index(값)을 통해 위치 검색