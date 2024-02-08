from sys import stdin
input = stdin.readline
R, L = input().rstrip().split()
if len(R) != len(L): print(0)
else:
    cnt = 0
    for i in range(len(R)):
        if R[i] == L[i]:
            if R[i] == '8': cnt += 1
        else: break
    print(cnt)