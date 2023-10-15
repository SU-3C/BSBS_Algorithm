# 10/15 14:30 / 이미 푼 문제 

def solution(places):
    answer = []
    for _ in range(0, 5):
        tp = []
        for __ in places[_]:
            tp.append(list(__))
        people = []

        # P에 붙어있는 O들을 기억 

        safe = True

        ways = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        for x in range(0, 5):
            if not safe:
                break
            for y in range(0, 5):
                if not safe:
                    break
                if tp[x][y] == "P":
                    for w in ways:
                        x2, y2 = w
                        try:
                            if x+x2 < 0 or y+y2 < 0 or x+x2 > 4 or y+y2 > 4:
                                continue
                            if tp[x+x2][y+y2] == "T" or tp[x+x2][y+y2]:
                                safe = not safe
                                break
                            if tp[x+x2][y+y2] == "O":
                                tp[x+x2][y+y2] = "T"
                        except:
                            pass
                    # print(safe, tp)

        # print(_, safe)

        answer.append(1 if safe else 0)

    return answer
    

t = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
print(solution(t))

