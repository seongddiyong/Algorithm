from heapq import heappush, heappop

def solution(n, k, enemy):
    stage = len(enemy)
    if k >= stage:
        return stage
    q = []
    
    for i in range(stage):
        heappush(q, enemy[i])
        if len(q) > k:
            last = heappop(q)
            if last > n:
                return i
            n -= last
        
    return stage