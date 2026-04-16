def solution(n, computers):
    visited = [False] * n
    result = 0
    for i in range(n):
        if visited[i]==False:
            dfs(n, computers, visited, i)
            result += 1
    return result
    
def dfs(n, computers, visited, node):
    visited[node] = True
    for i in range(n):
        if computers[i][node] == 1 and visited[i]==False:
            dfs(n, computers, visited, i)
        