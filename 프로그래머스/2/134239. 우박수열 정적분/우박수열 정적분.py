def lc(k,cnt,g,d):
    if k > 1:
        cnt += 1
        if k%2:
            st = k*3+1
        else:
            st = k/2
        x1, y1 = g[-1]
        y2_y1 = st - y1
        cal1 = y2_y1/2 * cnt**2 - (x1 * y2_y1 - y1) * cnt
        cal2 = y2_y1/2 * x1**2 - (x1 * y2_y1 - y1) * x1
        d.append(cal1 - cal2)
        g.append([cnt,st])
        return lc(st,cnt,g,d)
    return cnt

def solution(k, ranges):
    answer = []
    graph = [[0,k]]
    d = []
    cnt = 0
    l = lc(k,cnt,graph,d)
    for i,j in ranges:
        a = l+j
        if i > a:
            answer.append(-1.0)
        elif i == a:
            answer.append(0.0)
        else:
            answer.append(sum(d[i:a]))
    return answer