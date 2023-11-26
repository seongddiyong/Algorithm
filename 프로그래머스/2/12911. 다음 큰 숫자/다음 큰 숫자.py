def solution(n):
    cnt_n = bin(n).count("1")
    i = n+1
    while True:
        temp = bin(i).count("1")
        if temp == cnt_n:
            return i
        else:
            i += 1