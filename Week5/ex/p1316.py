# 1316 [s5] 그룹 단어 체커
from collections import deque

count = 0
for _ in range(0, int(input())):
    string = deque(input())
    last = "_"
    alpha = []
    connect = True
    while True:
        last = string.popleft()
        if last in alpha:
            connect = False
            break
        alpha.append(last)
        while len(string) > 0:
            if string[0] == last:
                string.popleft()
            else:
                break
        if len(string) == 0:
            break
    if connect:
        count = count + 1

print(count)