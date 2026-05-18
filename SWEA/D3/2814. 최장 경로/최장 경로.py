from collections import defaultdict

T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(M):
        s, e = map(int, input().split())
        graph[s].append(e)
        graph[e].append(s)

    visited = [False]*(N+1)
    result = [1]

    def dfs(n, c):
        result[0] = max(result[0], c)

        for nxt in graph[n]:
            if visited[nxt]: continue
            visited[nxt] = True
            dfs(nxt, c+1)
            visited[nxt] = False

    for i in range(N):
        dfs(i, 0)
    print(f'#{test_case} {result[0]}')