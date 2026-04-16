from collections import Counter

def solution(n, computers):
    set_arr = [i for i in range(n)]
    rank = [0]*n
    for i in range(n):
        for j in range(n):
            if computers[i][j]==1:
                union(set_arr, rank, i, j)
    
    for i in range(n):
        find(set_arr, i)
    counter = Counter(set_arr)
    return len(counter)

def find(arr, x):
    if arr[x]!=x:
        arr[x]=find(arr,arr[x])
    return arr[x]

def union(arr, rank, x, y):
    root_x = find(arr,x)
    root_y = find(arr,y)
    
    if root_x == root_y:
        return False
    
    if rank[root_x]<rank[root_y]:
        root_x, root_y = root_y, root_x
    arr[root_y] = root_x
    if rank[root_x] == rank[root_y]:
        rank[root_x] += 1
    return True