from sys import stdin
import math
input = stdin.readline
h, w, n, m = map(int, input().split())
print(math.ceil(h / (n + 1)) * math.ceil(w / (m + 1)))