# 08/10 08:21 (소모 : 1시간+) 
# 정확성 10/10, 효율성 0/5, 3트 실패

def solution(prices):
    leng = len(prices)


    zeros = [leng]

    pass
    # 플랜 4 맨뒤에 0 하나 붙이고 0 위치를 정리해서
    # 가장 낮은 수 부터 가장 가까운 0의 위치를 연산
    # 가장 가까운 0 - 현재 위치
    # 아 근데 당장 구현이 생각이 안나는 관계로 패스


def solution3(prices):
    leng = len(prices)
    answer = [0 for x in range(0, leng)]
    table = [1]
    top = max(prices)

    while True:
        # print("P: ", prices, top)
        t = prices.index(top)
        # print(t, "top", top)
        cnt = 1
        for x in prices[t+1:]:
            if x != 0 and x < top:
                # print("??", answer[t], t, cnt)
                answer[t] = cnt
                break
            else:
                cnt = cnt + 1
        else:
            answer[t] = leng - t - 1
        prices[t] = 0

        # print(f't {t}, an {answer}, p {prices}')
        # print("A: ", answer)

        top = max(prices)
        if top == 0:
            break

    answer[-1] = 0

    return answer
# 가장 높은 수부터 0으로 치환해가며 지우는 방식

def solution2(prices):
    answer = [0 for x in range(0, len(prices))]
    table = [1]

    for x in prices[1:]:
        print(table)
        for i, y in enumerate(table):
            # y == table[i]
            if y == -1:
                continue
            else:
                if prices[i] > x:
                    answer[i] = y
                    table[i] = -1
                else:
                    table[i] = table[i] + 1
        table.append(1)

    for i, x in enumerate(table):
        if x != -1:
            answer[i] = x - 1

    answer[-1] = 0

    return answer
# 테이블에 1을 계속 추가해 자신보다 작은 값이 나올때까지 증가
# 정확성 10/10, 효율성 0/5 (2트)

def solution1(prices):
    answer = []
    length = len(prices)

    for x in range(0, length-1):
        # print(f"x:{x} {answer}")
        t = prices[x]
        print(prices[x+1:])
        q = list(filter(lambda i: i<t, prices[x+1:]))

        print(f't: {t}, q: {q}')

        if q:
            answer.append(1+prices[x+1:].index(q[0]))
        else:
            answer.append(length - 1 - x)

    answer.append(0)
    return answer
# filter함수를 이용해 가장 앞의 자신보다 작은 수를 가져와 해결
# 정확성 10/10, 효율성 0/5 (1트)

p = [5, 8, 6, 2, 4, 1] 
p = [1, 2, 3, 2, 3]
# p = [5, 4, 3, 2, 1]

t = solution(p)
print(t)