def solution(rows, columns, queries):
    answer = []
    d = [(1,0),(0,1),(-1,0),(0,-1)]
    g = []
    cnt = 1
    for i in range(rows):
        temp = []
        for j in range(columns):
            temp.append(cnt)
            cnt += 1
        g.append(temp)
    for i in queries:
        res = []
        goto = [i[3]-i[1], i[2]-i[0]]*2
        x, y = i[0], i[1]
        prev = g[x-1][y-1]
        for j in range(4):
            dy, dx = d[j]
            for _ in range(goto[j]):
                res.append(prev)
                nx, ny = x+dx, y+dy
                nextValue = g[nx-1][ny-1]
                g[nx-1][ny-1] = prev
                prev = nextValue
                x, y = nx, ny
        answer.append(min(res))
        
    return answer