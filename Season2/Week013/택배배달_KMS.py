# 09/24 15:36 1150(+12)

# cap, n, deli, pick, res

# 무조건 최대한 많이 실어서 멀리부터 배달하는게 최적화
# 최대한 실어 멀리 배달하고 수거가능한 최대치만큼 들고오기

# 상태를 2개로 구분 (배달, 수거)
# 배달이 끝에 도달하면 택배 수량만큼 차감, 수거로 상태를 변경
# 수거 상태에서는 오는 길에 있는 수거 택배를 차감하며 이동
# 횟수 관리는 가장 먼 idx X 2

# 최초 전처리로 배달, 수거 배열 2개 생성
# 아까 말했던 key pair를 배열에 저장해서 pop, push 반복

def solution(cap, n, deliveries, pickups):
    answer = 0

    deli = []
    pick = []

    # 값 전처리

    for x in range(0, n):
        if deliveries[x] != 0:
            deli.append((x+1, deliveries[x]))
        if pickups[x] != 0:
            pick.append((x+1, pickups[x]))

    print(deli, pick)

    # 이동 시작

    while len(deli) > 0 or len(pick) > 0:
        print(deli, pick)
        # 배달 시작
        dlen = -1
        plen = -1

        if len(deli) > 0:
            move = cap
            print(f'm {move}')
            pt = -1
            pc = -1

            while True:  # dt: deli dist, dc: deli count
                if move < 0: # pop 이후 push
                    deli.append((dt, abs(move)))
                    break
                elif move == 0:
                    break
                if len(deli) == 0:
                    break
                dt, dc = deli.pop()
                dlen = max(dlen, dt)
                print(move)

                move = move - dc

        if len(pick) > 0:
            move = cap
            pt = -1
            pc = -1

            while True:
                if move < 0:
                    pick.append((pt, abs(move)))
                    break
                elif move == 0:
                    break
                if len(pick) == 0:
                    break
                pt, pc = pick.pop() # pick dist, pick count
                plen = max(plen, pt)
                move = move - pc

        # 이동 종료

        answer = answer + max(dlen, plen)
        print(f'to {answer}')

    return answer * 2

tc1 = [4, 5, [1, 0, 3, 1, 2], [0, 3, 0, 4, 0]]
tc2 = [2, 7, [1, 0, 2, 0, 1, 0, 2], [0, 2, 0, 1, 0, 2, 0]]
tc3 = [1, 5, [0, 1, 1, 1, 1], [1, 1, 1, 1, 1]]
t = print(solution(*tc3))
