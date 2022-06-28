# 1764 [s4] 듣보잡 - 실패

import sys
from collections import deque

dic_s = []

_, *d = open(0)

idx = int(_.rstrip().split()[1])

find = deque(d[:idx])
table = deque(d[idx:])

for x in table:
    if find.find(x) != -1:
        print(x.rstrip())
