# 15650 [s3] N과 M (2)

N, M = map(int, input().split())

def choose(s, n, m):
    if m == 1:
        for x in n:
            print(f'{s} {x}'.strip())
    else:
        for x in n:
            c = f'{s} {x}'
            choose(c.strip(), [z for z in range(x+1, N+1)], m-1)

choose("", [x for x in range(1, N+1)], M)