def solution(s):
    s = list(map(int,s.split(' ')))
    s = [min(s),max(s)]
    return ' '.join(map(str,s))