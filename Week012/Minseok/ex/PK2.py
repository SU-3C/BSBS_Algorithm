# Programmers 2022 Kakao Blind Recuit 신고 결과 받기

# Link https://school.programmers.co.kr/learn/courses/30/lessons/92334

def solution(id_list, report, k):
    answer = []
    
    dic = dict([(x, set()) for x in id_list])
    report_count = dict([(x, 0) for x in id_list])
    
    for x in report:
        a, b = x.split()
        dic[b].add(a)
        
    for x in id_list:
        if len(dic.get(x)) >= k:
            for y in dic.get(x):
                report_count[y] += 1
        # print(f'{x} {dic.get(x)} {len(dic.get(x))}');
    
    # for x, y in report_count.items():
    #     print(f'{x} {y}')
    
    answer = list(report_count.values())
    # print(f'{answer}')
    
    return answer