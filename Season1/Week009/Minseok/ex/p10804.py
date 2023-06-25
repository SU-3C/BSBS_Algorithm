# 10804 [b2] 카드 역배치

cards = [str(x) for x in range(1, 21)]

for _ in range(10):
    a, b = map(int, input().split())
    cards[a-1:b] = cards[a-1:b][::-1]

print(f'{" ".join(cards)}')
