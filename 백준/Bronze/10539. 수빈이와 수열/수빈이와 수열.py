from sys import stdin
from collections import Counter
input = stdin.readline

n = int(input())
li = list(map(int, input().split()))
a = 0
total = 0
for i, num in enumerate(li):
    N = num * (i+1)
    a = N - total
    total += a
    print(a, end=' ')