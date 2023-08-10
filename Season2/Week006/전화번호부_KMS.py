# 08/06 16:++ (실패)


def solution(phone_book):
    answer = True
    flag = True
    dic = [[] for x in range(0, 10)]

    for x in phone_book:
        dic[int(x[0])].append(x)

    for x in dic:
        t = sorted(x, key=len, reverse=True)
        while t:
            y = t.pop()
            l = len(y)
            for q in t:
                if y == q[:l]:
                    answer = False
                    flag = False

            if not flag:
                break

    return answer
# 시작 0~9번 단위로 끊어 내부에서 비교
# 정확성 (20/20) 효율성 (2/4)

def solution2(phone_book):
    answer = True
    flag = True
    pb = sorted(phone_book, key=len, reverse=True)

    while pb:
        c = pb.pop()
        print(pb)
        l = len(c)
        for x in pb:
            print(c, x[:l])
            if c in x[:l]:
                answer = False
                flag = False
                break

        if not flag:
            break

    return answer

# 전체 순회
# 정확성 (20/20) 효율성 (2/4

tc = ["119", "97674223", "1195524421"]
tc =  ["119", "114", "112", "123223123", "1231231234"]
t = solution(tc)
print(t)