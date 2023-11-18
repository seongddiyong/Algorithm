def solution(N, road, K):
    graph = [[int(1e9) for _ in range(N+1)] for _ in range(N + 1)]

    for i in range(1, N+1):
        graph[i][i] = 0

    for i, j, c in road:
        graph[i][j] = min(graph[i][j], c)
        graph[j][i] = min(graph[j][i], c)

    for k in range(1, N+1):    
        for i in range(1, N+1):
            for j in range(1, N+1):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
    ans = [x for x in graph[1] if x <=K]
    return len(ans)