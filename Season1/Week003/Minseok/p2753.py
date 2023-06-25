# 2753 [b4] 윤년

i = int(input())
f = 0

if i % 4 == 0:	# Flag를 더해서 2로 나눠서 1이 남으면 윤년
	f = f + 1
if i % 100 == 0:
	f = f + 1
if i % 400 == 0:
	f = f + 1

print((1 if f%2==1 else 0))	

# a = int(input());
# print(1 if a%400==0 else 1 if a%4==0 and a%100!=0 else 0);
# 예전 코드 : 다항연산자 두번 사용