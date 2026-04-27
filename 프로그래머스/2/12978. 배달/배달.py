from collections import defaultdict
import heapq

def solution(N, road, K):
    nodes = defaultdict(list)
    for n1, n2, weight in road:
        nodes[n1].append((n2, weight))
        nodes[n2].append((n1, weight))
    visited = [False]*(N+1)
    costs = [float('inf')]*(N+1)
    costs[1] = 0
    queue = [(0,1)]
    
    while queue:
        cur_weight, cur_node = heapq.heappop(queue)
        if visited[cur_node]: continue
        visited[cur_node] = True
        for next_node, next_cost in nodes[cur_node]:
            new_cost = cur_weight + next_cost
            if new_cost < costs[next_node]:
                costs[next_node] = new_cost
                heapq.heappush(queue, (new_cost, next_node))
    
    result = 0
    for i in costs:
        if i<=K: result+=1
    return result