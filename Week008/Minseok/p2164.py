# 2164 [s4] 카드2

from collections import deque

cards = deque([x for x in range(1, int(input())+1)])

while len(cards) > 1:
    # 한장이 남을때까지 반복

    cards.popleft() 
    # 가장 위에 있는 카드를 pop
    cards.append(cards.popleft()) 
    # 그 이후 가장 위의 카드를 가장 뒤로 이동

print(cards.pop())
