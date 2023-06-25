# 3190 [g4] 뱀

# 0 : blank, 1 : apple, 9 : snake

from collections import deque

N = int(input()) # 보드의 크기
board = [[0 for x in range(N)] for x in range(N)]

direction = [(1, 0), (0, 1), (-1, 0), (0, -1)]

K = int(input()) # 사과의 갯수
apple = [(map(int, input().split())) for x in range(K)]

L = int(input())
cmd = deque([input().split() for x in range(L)])

for x in apple:
    a, b = x
    board[a-1][b-1] = 1

snake = deque([(0, 0)])
direct = 0
sec = 0

while True:
    sec += 1
    next_x, next_y = map(lambda x, y: x+y, snake[0], direction[direct])
    if next_x < 0 or N <= next_x or next_y < 0 or N <= next_y:
        # 벽에 충돌한 경우
        print(sec)
        break

    c = board[next_y][next_x]
    if (next_x, next_y) in snake or c == 9:
        # 본인의 몸에 충돌한 경우
        print(sec)
        break
    elif c == 1:
        # 사과를 먹었을 경우
        snake.appendleft((next_x, next_y))
        board[next_y][next_x] = 0

    else:
        # 위의 세 경우를 제외한 이동하는 경우
        snake.pop()
        snake.appendleft((next_x, next_y))

    if cmd and cmd[0][0] == str(sec):
        c, c2 = cmd.popleft()
        if c2 == 'L':
            direct = 3 if direct - 1 < 0 else direct - 1
        elif c2 == 'D':
            direct = 0 if direct + 1 > 3 else direct + 1