def solution(n, costs):
    set_arr = [i for i in range(n)]
    rank = [0]*n
    costs = sorted(costs, key=lambda x:x[2])
    result = 0
    for cost in costs:
        if union(set_arr, rank, cost[0], cost[1]):
            result += cost[2]
    return result

def find(arr, x):
    if arr[x] != x:
        arr[x] = find(arr, arr[x])
    
    return arr[x]

def union(arr, rank, x, y):
    root_x = find(arr, x)
    root_y = find(arr, y)
    
    if root_x == root_y:
        return False
    
    if rank[root_x] < rank[root_y]:
        root_x, root_y = root_y, root_x    
    arr[root_y] = root_x
    if rank[root_x] == rank[root_y]:
        rank[root_x] += 1
    return True