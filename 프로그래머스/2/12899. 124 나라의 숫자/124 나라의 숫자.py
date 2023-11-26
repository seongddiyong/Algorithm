def solution(n):
    answer = []
    while n:
        if n%3:
            answer.append(n%3)
            n //= 3
        else:
            answer.append(4)
            n = n//3-1
    return ''.join(map(str,answer[::-1]))