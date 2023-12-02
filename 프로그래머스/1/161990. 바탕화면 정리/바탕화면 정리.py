def solution(wallpaper):
    tempx = []
    tempy = []
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == '#':
                tempx.append(i)
                tempy.append(j)
            else:
                continue
    return [min(tempx), min(tempy), max(tempx)+1, max(tempy)+1]