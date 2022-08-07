# Programmers 2021 Dev-Matching 로또의 최고 순위와 최저 순위

# Link https://school.programmers.co.kr/learn/courses/30/lessons/77484

def solution(lottos, win_nums):
    answer = []
    lottos.sort()
    win_nums.sort()
    
    zero = lottos.count(0)
    lottos = lottos[zero:]

    flag = 0

    for x in lottos:
        try:
            win_nums.remove(x)
        except:
            flag += 1


    correct = 6-len(win_nums)

    print(f'맞은거 : {correct} 0의 갯수 : {zero}')

    high = 7 - (correct+zero if correct+zero > 1 else 1)
    low = 7 - (correct if correct > 1 else 1)

    answer = (high, low)

    return answer


a1 = [44, 1, 0, 0, 31, 25]
b1 = [31, 10, 45, 1, 6, 19]
c = [3, 5]

d = [1, 2, 3, 4, 5, 0]
e = [1, 2, 3, 4, 5, 6]

a2 = [0, 0, 0, 0, 0, 0] 
b2 = [38, 19, 20, 40, 15, 25]    
a3 = [45, 4, 35, 20, 3, 9] 
b3 =  [20, 9, 3, 45, 4, 35]   

print(solution(a1, b1))
print(solution(a2, b2))
print(solution(a3, b3))
print(solution(d, e))
