from collections import defaultdict

def solution(n, computers):
    visited = set()
    tree = defaultdict(list)
    for i in range(n):
        tree[i] = []
        for j in range(n):
            if i!=j and computers[i][j]==1:
                tree[i].append(j)
    
    def dfs(node):
        visited.add(node)
        for i in tree[node]:
            if i not in visited:
                dfs(i)
                
    result = 0
    for t in tree:
        if t not in visited:
            dfs(t)
            result += 1
                
    return result