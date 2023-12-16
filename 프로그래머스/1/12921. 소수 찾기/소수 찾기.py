def isPrime(n):
    for i in range(2,int(n**0.5)+1):
        if not n%i: return 0
    return 1

def solution(n):
    answer = 0
    for i in range(2,n+1): answer += isPrime(i)
    return answer