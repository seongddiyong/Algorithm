from sys import stdin
import math
input = stdin.readline
n = int(input())
dp = [0, 1, 1]
if n <= 2:
    print(1)
else:
    for i in range(3, n + 1):
        dp.append(dp[i-1] + dp[i-2])
    print(dp[n])