from collections import deque

def solution(n, edge):
    graph = [[] for _ in range(n+1)]
    for x,y in edge:
        graph[x] += [y]
        graph[y] += [x]
    visited = [False for _ in range(n+1)]
    visited[1] = 1
    
    queue = deque([1])
    
    while queue:
        cur = queue.popleft()
        for i in graph[cur]:
            if not visited[i]:
                visited[i] = visited[cur]+1
                queue.append(i)
    
    return visited.count(max(visited))