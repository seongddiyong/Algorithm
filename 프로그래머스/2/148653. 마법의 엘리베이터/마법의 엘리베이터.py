def solution(storey):
    answer = 0
    while storey:
        temp = storey%10
        if temp > 5:
            answer += 10-temp
            storey += 10
        elif temp == 5 and (storey//10)%10 > 4:
            storey += 10
            answer += temp
        else:
            answer += temp
        storey //= 10
    return answer