def solution(park, routes):
    d = {"E": (1,0), "W": (-1,0), "S": (0,1), "N": (0,-1)}
    for i in range(len(park)):
        if "S" in park[i]:
            x, y = park[i].index("S"), i
            break
    for i in routes:
        tempx, tempy = x, y
        v, cnt = i.split()
        dx, dy = d[v]
        for j in range(int(cnt)):
            if 0 <= tempx + dx < len(park[0]) and 0 <= tempy + dy < len(park) and park[tempy+dy][tempx+dx] != "X":
                tempx, tempy = tempx + dx, tempy + dy
            else:
                break
        else:
            x, y = tempx, tempy
    return [y,x]