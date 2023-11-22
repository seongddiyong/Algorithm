def solution(g, p):
    answer = []
    d = {}
    temp = [[g[i], p[i], i] for i in range(len(g))]
    temp = sorted(temp, key = lambda x: (x[0], -x[1], x[2]))
    for t in temp:
        if t[0] not in d:
            d[t[0]] = t[1]
        else:
            d[t[0]] += t[1]
    d = sorted(d.items(), key = lambda x: -x[1])
    for i in d:
        cnt = 0
        for j in temp:
            if i[0] == j[0]:
                cnt += 1
                if cnt > 2: break
                else: answer.append(j[2])
    return answer