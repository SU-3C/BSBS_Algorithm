# 1212 [b3] 8진수 2진수

# from time import time # time 모듈 import
# a = time() # 시작 시간 저장

i = int(input(), 8) # 입력값을 8진수로 저장
print("{0:b}".format(i))    # 2진수로 출력

# s = "" # 문자열을 2진수로 저장한건데
# for x in input(): # 시간 초과로 실패
#     s += "{0:0>3b}".format(int(x))

# b = time() # 종료 시간 저장
# print(b-a) # 걸린 시간 출력