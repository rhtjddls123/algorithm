from collections import defaultdict
import heapq

T = int(input())

for test_case in range(1, T + 1):
    N, E = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(E):
        s, e, w = map(int, input().split())
        graph[s].append((e, w))
    costs = [float('inf')]*(N+1)
    costs[0] = 0
    queue = [[0, 0]]
    visited = [False] * (N+1)
    while queue:
        cur_cost, start = heapq.heappop(queue)
        if visited[start]: continue
        visited[start] = True
        for nxt in graph[start]:
            nxt_num, nxt_cost = nxt
            if costs[nxt_num] > cur_cost + nxt_cost:
                costs[nxt_num] = cur_cost+nxt_cost
                heapq.heappush(queue, [cur_cost+nxt_cost, nxt_num])

    print(f'#{test_case} {costs[N]}')