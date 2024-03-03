from sys import stdin
from collections import deque

input = stdin.readline

def left(num, d):
    if num < 0: return
    if t[num][2] != t[num+1][6]:
        left(num - 1, -d)
        t[num].rotate(d)

def right(num, d):
    if num > 3: return
    if t[num - 1][2] != t[num][6]:
        right(num + 1, -d)
        t[num].rotate(d)


t = [deque(list(map(int, input().rstrip()))) for _ in range(4)]

K = int(input())
answer = 0

for turn in range(K):
    num, d = map(int, input().split())
    num -= 1
    left(num - 1, -d)
    right(num + 1, -d)
    t[num].rotate(d)

for i in range(4):
    if t[i][0]:
        answer += 2 ** i
print(answer)