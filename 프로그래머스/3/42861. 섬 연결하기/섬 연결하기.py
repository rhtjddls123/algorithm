def solution(n, costs):
    arr = [x for x in range(n)]
    result = 0
    costs = sorted(costs, key=lambda x:x[2])
    for cost in costs:
        if (union(arr, cost[0], cost[1])):
            result += cost[2]
    return result
    
def find(arr, x):
    if(arr[x]==x):
        return x
    
    return find(arr, arr[x])

def union(arr, x, y):
    root_x = find(arr, x)
    root_y = find(arr, y)
    if root_x != root_y:
        arr[root_y] = root_x
    return root_x != root_y