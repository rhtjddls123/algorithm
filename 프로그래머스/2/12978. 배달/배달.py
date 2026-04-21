from collections import defaultdict
import heapq

def solution(N, road, K):
    nodes = defaultdict(list)
    for from_node, to_node, weight in road:
        nodes[from_node].append((to_node, weight))
        nodes[to_node].append((from_node, weight))
    visited = [False] * (N+1)
    times = [float('inf')] * (N+1)
    times[1] = 0
    queue = [(0, 1)]
    while queue:
        cur_time, cur_node = heapq.heappop(queue)
        if visited[cur_node]: continue
        visited[cur_node] = True
        
        for n, w in nodes[cur_node]:
            new_time = cur_time + w
            if times[n] > new_time:
                times[n] = new_time
                heapq.heappush(queue, (new_time, n))
    
    result = 0
    for t in times:
        if t<=K: result+=1
        
    return result