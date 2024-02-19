import sys
input = sys.stdin.readline

S = input().rstrip()
answer = [0 for i in range(26)]

for i in S:
    answer[ord(i) - 97] += 1
    
for i in answer:
    print(i, end=' ')