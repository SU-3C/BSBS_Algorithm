# 10250 [b3] ACM 호텔

# 구 버전

for q in range(0, int(input())):
	a, b, c = map(int, input().split())

	y = 1
	z = 0

	while True:
		if(c <= a): break
		c = c-a # 
		y = y+1 # 층 뺀 카운트

		
	z = c*100 + y

	print(z)