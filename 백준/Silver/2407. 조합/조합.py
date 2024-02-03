DP = [1,5,10,10,5,1]
n, m = map(int, input().split())
for _ in range(n-5):
    new_dp = [1]
    for i in range(len(DP)-1):
        new_dp.append(DP[i]+DP[i+1])
    new_dp.append(1)
    DP = new_dp
print(DP[m])