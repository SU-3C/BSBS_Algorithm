# 08/06 16:++ 1121(+10)

def solution(clothes):
    answer = 1
    dic = {}
    for cloth in clothes:
    # print(b)
        if dic.get(cloth[-1]):
            dic[cloth[-1]] = dic[cloth[-1]] + 1
        else:
            dic[cloth[-1]] = 2

    for x in dic.values():
        answer = answer * x
    
    return answer - 1