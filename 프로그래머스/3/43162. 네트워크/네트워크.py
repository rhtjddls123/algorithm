from collections import Counter

def solution(n, computers):
    network = [i for i in range(n)]
    rank = [0]*n
    for i in range(n):
        for j in range(n):
            if computers[i][j]==1:
                union(network, rank, i, j)
    for i in range(n):
        find(network, i)
    counter = Counter(network)
    
    return len(counter)

def find(arr, x):
    if arr[x] != x:
        arr[x] = find(arr, arr[x])
    return arr[x]

def union(arr, rank, x, y):
    nodeX = find(arr, x)
    nodeY = find(arr, y)
    if nodeX == nodeY: return

    if rank[nodeX] < rank[nodeY]:
        nodeX, nodeY = nodeY, nodeX
    arr[nodeY] = nodeX
    if rank[nodeX] == rank[nodeY]:
        rank[nodeX] += 1