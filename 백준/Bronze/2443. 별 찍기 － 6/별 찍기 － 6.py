from sys import stdin
import math
input = stdin.readline
n = int(input())
for i in range(n):
    print(" " * i + '*' * (n - i - 1) + '*' + '*' * (n - i - 1))