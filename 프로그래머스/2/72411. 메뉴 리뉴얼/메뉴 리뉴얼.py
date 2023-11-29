from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    for i in course:
        temp = []
        for j in orders:
            for k in combinations(j,i):
                t = ''.join(sorted(k))
                temp.append(t)
        sorted_temp = Counter(temp).most_common()
        answer += [m for m, cnt in sorted_temp if cnt > 1 and cnt == sorted_temp[0][1]]
    return sorted(answer)