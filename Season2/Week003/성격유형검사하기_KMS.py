def solution(survey, choices):
    answer = ''
    key = "RTCFJMAN"
    dic = [0 for x in range(0, 8)]
    for x, y in zip(survey, choices):
        fir, sec = x
        if y-4 < 0:
            i = key.find(fir)
            dic[i] = dic[i] + abs(y-4)
        else:
            i = key.find(sec)
            dic[i] = dic[i] + abs(y-4)
            
    for x in range(0, 4):
        if dic[x*2] < dic[x*2+1]:
            answer = answer + key[x*2+1]
        else:
            answer = answer + key[x*2]
    
    return answer