def solution(prices):
    l = len(prices) 
    answer = [i for i in range (l-1, -1, -1)]
    s = [0]
    for i in range (1, l):
        while s and prices[s[-1]] > prices[i]:
            j = s.pop()
            answer[j] = i - j
        s.append(i)
    return answer