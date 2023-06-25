# 10610 [s4] 30

i = input()

if not "0" in i:
    print(-1)
    __import__("sys").exit(0)

t = sum(map(int, i))
if t % 3 != 0:
    print(-1)
    __import__("sys").exit(0)
    
arr = list([x for x in i])
arr.sort(reverse=True)

for x in arr:
    print(x, end="")