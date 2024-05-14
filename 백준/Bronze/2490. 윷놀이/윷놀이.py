from sys import stdin
import math
input = stdin.readline
for _ in range(3):
    temp = list(map(int, input().split()))
    cnt = temp.count(1)
    if cnt == 0:
        print("D")
    elif cnt == 1:
        print("C")
    elif cnt == 2:
        print("B")
    elif cnt == 3:
        print("A")
    else:
        print("E")