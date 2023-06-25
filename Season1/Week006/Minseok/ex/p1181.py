# 1181 [s5] 단어 정렬

import sys

words = [sys.stdin.readline().strip() for x in range(int(sys.stdin.readline()))]

sorted_words = sorted(sorted(set(words)), key=lambda x: len(x))

for x in sorted_words:
    print(x)


