#input();a=input().split();i=len(a)
#while i:i//=2;print(f'-{i}-{i*2+2}');print(*a[i::i*2+2])

t={}
for i in[*open(0)][1:]:a,*b=i.split();t[a]=b
r=[""]*3
print(t)
def f(x):
 if"."!=x:r[0]+=x;f(t[x][0]);r[1]+=x;f(t[x][1]);r[2]+=x
f("A")
*map(print,r),