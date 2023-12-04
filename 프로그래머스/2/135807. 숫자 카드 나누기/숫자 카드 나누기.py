from math import gcd

def notDiv(array, gcd):
    for n in array:
        if n % gcd == 0: return False
    return True

def solution(arrayA, arrayB):
    answer = 0
    gcdA = arrayA[0]
    gcdB = arrayB[0]
    for n in arrayA[1:]: gcdA = gcd(n, gcdA) 
    for n in arrayB[1:]: gcdB = gcd(n, gcdB)
    if notDiv(arrayA, gcdB): answer = max(answer, gcdB)
    if notDiv(arrayB, gcdA): answer = max(answer, gcdA)
    return answer