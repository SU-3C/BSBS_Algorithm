# 2164 [s4] 카드2

from collections import deque

cards = deque([x for x in range(1, int(input())+1)])

while len(cards) > 1:
    cards.popleft()
    cards.append(cards.popleft())

print(cards.pop())