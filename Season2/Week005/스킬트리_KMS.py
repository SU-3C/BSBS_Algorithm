# 07/27 23:50 1102(+14)

def solution(skill, skill_trees):
    answer = 0
    print(skill)

    for tree in skill_trees:
        able = True
        cap = list(skill[::-1])

        for x in tree:
            if x in cap:
                if x != cap[-1]:
                    able = False
                    break
                else:
                    cap.pop()

        if able:
            answer = answer + 1

    return answer

a = "CBD"
b = ["BACDE", "CBADF", "AECB", "BDA"]

t = solution(a, b)
print(t)