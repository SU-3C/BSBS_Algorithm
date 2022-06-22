# 12605 [b1] 단어순서 뒤집기

import sys

cmd = [sys.stdin.readline() for x in range(int(sys.stdin.readline()))]
# 단어들의 리스트

for i, x in enumerate(cmd):
    print(f'Case #{int(i)+1}: ', end="")
    # print format
    
    for y in reversed(x.split(" ")): # 띄어쓰기 단위로 문자배열을 만들어 뒤집기
        print(y.strip(), end=" ")
    # 줄바꿈 문자 제거 후 출력
    print() # 줄 바꿈
