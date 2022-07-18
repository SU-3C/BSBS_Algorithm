from time import time

s1 = time()

a = []

for x in range(0, 100000):
    a[0:0] = x,

e1 = time()


s2 = time()

b = []

for x in range(0, 100000):
    a.insert(0, x)

e2 = time()

print("1: ", e1 - s1)
print("2: ", e2 - s2)
