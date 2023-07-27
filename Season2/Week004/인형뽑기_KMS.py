# 07/27 22:28 1075(+10)

def solution(board, moves):
    answer = 0

    lenX = len(board[0])
    box = [[] for x in range(0, lenX)]

    popbox = []

    for x in board:
        for y in range(0, len(x)):
            value = x[y]
            if value != 0:
                box[y].append(value)

    for x in moves:
        if len(box[x-1]) == 0:
            continue
        t = box[x-1][0]
        del box[x-1][0]

        #print("get p: ", t)

        if len(popbox) != 0 and popbox[-1] == t:
            popbox.pop()
            answer = answer + 2
        else:
            popbox.append(t)

        #print("popbox", popbox, " cnt: ", answer)

    return answer

b = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
m = [1,5,3,5,1,2,1,4]

t=solution(b, m)
print(t)

