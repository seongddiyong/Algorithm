from collections import Counter

def solution(weights):
    answer = 0
    w = Counter(weights)
    for i in w:
        answer += w[i]*(w[i]-1)//2
        for j in [0.75,1.5,2]:
            answer += w[i]*w[i*j]
    return answer