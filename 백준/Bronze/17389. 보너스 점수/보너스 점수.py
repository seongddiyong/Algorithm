from sys import stdin
input = stdin.readline
n = int(input())
cnt = -1
answer = 0
for k,i in enumerate(input().rstrip()):
    if i == "X":
        cnt = -1
    else:
        cnt += 1
        answer += k+1+cnt
print(answer)