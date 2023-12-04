from collections import deque

def bfs(x,y,n,m,maps,visited):
    dx, dy = [0,0,-1,1], [1,-1,0,0]
    q = deque()
    q.append((x,y))
    cnt = 0
    while q:
        x,y = q.popleft()
        if visited[y][x]:
            continue
        cnt += int(maps[y][x])
        visited[y][x] = 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and not visited[ny][nx] and maps[ny][nx] != 'X':
                q.append((nx,ny))
    return cnt

def solution(maps):
    answer = []
    n,m = len(maps), len(maps[0])
    visited = [[0]*m for _ in range(n)]
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] != 'X' and not visited[i][j]:
                answer.append(bfs(j,i,n,m,maps,visited))
    return sorted(answer) if answer else [-1]