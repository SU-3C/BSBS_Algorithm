def solution(new_id):
    answer = ''
    
    temp = pro1(new_id)
    #print(temp)
    temp = pro2(temp)
    #print(temp)
    temp = pro3(temp)
    #print(temp)
    temp = pro4(temp)
    #print(4, temp)
    temp = pro5(temp)
    #print(5, temp)
    temp = pro6(temp)
    #print(6, temp)
    temp = pro7(temp)
    #print(7, temp)
    answer = temp
    return answer

def pro1(keyword):
    res = keyword.lower()    
    return res

def pro2(keyword):
    res = ""
    for x in keyword:
        if x in "abcdefghijklmnopqrstuvwxyz0123456789-_.":
            res = res + x
    
    return res

def pro3(keyword):
    res = ""
    res = ".".join([x for x in keyword.split(".") if x])
    return res
    
    
def pro4(keyword):
    res = ""
    if not keyword:
        return res
    t = list(keyword)
    last = -2
    cnt = -1
    while last != cnt:
        last = len(t)
        if t[0] == ".": del t[0]
        if t[-1] == ".": del t[-1]
        cnt = len(t)  
    res = "".join(t)
    return res

def pro5(keyword):
    res = keyword
    if len(keyword) == 0:
        res = "a"
    
    return res

def pro6(keyword):
    res = ""
    if len(keyword) > 15:
        res = pro3(keyword[0:15])
    else : 
        res = keyword
    #print("len", len(res))
    return res

def pro7(keyword):
    res = keyword
    while len(keyword) < 3:
        keyword = keyword + keyword[-1]
    res = keyword
    return res


#solution("...!@BaT#*..y.abcdefghijklm")