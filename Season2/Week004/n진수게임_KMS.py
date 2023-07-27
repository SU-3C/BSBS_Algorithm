# 07/27 23:03 1088(+13)

def solution(n, tar, m, p):
    full_dic = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd', 'e', 'f']

    dic = full_dic[0:n]

    print(dic)

    answer = ''
    number = 0
    count = p

    while True:
        t = process(number, dic, n)
        for x in t:
            count = count - 1
            # print("number: ", number, " t:", t, " x: ", x)
            if count == 0:
                answer = answer + x
                count = m

        if len(answer) >= int(tar):
            break
        number = number + 1

    return answer[0:tar].upper()

def process(n, dic, l):
    res = ''
    if n >= l:
        res = process(n//l, dic, l) + str(dic[n%l])
    else:
        # n < l
        res = str(dic[n])
    return res



t = solution(2, 1000, 100, 77)
print(t)
# t = solution(16, 16, 2, 1)
# print(t)
# t = solution(16, 16, 2, 2)
# print(t)
