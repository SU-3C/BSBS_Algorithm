# 07/28 00:39 1111(+9)

def solution(p, s):
    answer = []
    q = []

    for x, y in zip(p, s):
        q.append((x, y))

    w = lambda x: (x[0]+x[1], x[1])

    while len(q) > 0:
        t_q = []
        for x in q:
            t_q.append(w(x))
            q = t_q
        if q[0][0] < 100:
            continue
        else:
            t_len = len(q)
            while q and q[0][0] > 99:
                q.pop(0)
            answer.append(t_len - len(q))

    return answer

p = [[93, 30, 55], [95, 90, 99, 99, 80, 99]]
s = [[1, 30, 5], [1, 1, 1, 1, 1, 1]]

t = solution(p[0], s[0])
print(t)

t = solution(p[1], s[1])
print(t)