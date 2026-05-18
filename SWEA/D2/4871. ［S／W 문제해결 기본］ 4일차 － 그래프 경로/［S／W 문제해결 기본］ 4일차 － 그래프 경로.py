from collections import defaultdict

T = int(input())
for test_case in range(1, T + 1):
    V, E = map(int, input().split())
    graph = defaultdict(list)

    for _ in range(E):
        s, e = map(int, input().split())
        graph[s].append(e)

    S, G = map(int, input().split())
    visited = [False] * (V+1)
    result = [0]
    def dfs(s, g):
        if s==g:
            result[0] = 1
            return

        for nxt in graph[s]:
            if visited[nxt]: continue
            visited[nxt] = True
            dfs(nxt, g)
            visited[nxt] = False

    dfs(S, G)

    print(f'#{test_case} {result[0]}')