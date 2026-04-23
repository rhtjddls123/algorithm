from collections import defaultdict
import heapq

def solution(N, road, K):
    nodes = defaultdict(list)
    for f_node, s_node, weight in road:
        nodes[f_node].append((s_node, weight))
        nodes[s_node].append((f_node, weight))
    visited = [False] * (N+1)
    distance = [float('inf')] * (N+1)
    distance[1] = 0
    queue = [(0, 1)]
    
    while queue:
        cur_weight, cur_node = heapq.heappop(queue)
        if visited[cur_node]: continue
        visited[cur_node] = True
        
        for next_node, next_weight in nodes[cur_node]:
            new_weight = cur_weight + next_weight
            if distance[next_node] > new_weight:
                distance[next_node] = new_weight
                heapq.heappush(queue, (new_weight, next_node))
    
    result = 0
    for cost in distance:
        if cost<=K: result += 1
    return result