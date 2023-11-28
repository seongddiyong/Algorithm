import math
def solution(k, d):
    answer = d//k*2+1
    for i in range(k,d+1,k):
        e = int(math.sqrt((d**2 - i**2)))
        answer += e//k
    return answer