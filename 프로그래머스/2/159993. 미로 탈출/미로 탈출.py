from collections import deque

def solution(maps):
    start=[]
    lever=[]
    exit=[]
    for i in range(len(maps)):
        for j in range(len(maps[i])):
            if(maps[i][j]=='S'):
                start = [i,j]
            if(maps[i][j]=='L'):
                lever = [i,j]
            if(maps[i][j]=='E'):
                exit = [i,j]
    
    a=bfs(start,lever,maps)
    if(a==-1): return -1
    b=bfs(lever,exit,maps)
    if(b==-1): return -1
    return a+b

def bfs(start, target, map):
    queue = deque()
    queue.append(start)
    n = len(map)
    m = len(map[0])
    dir = [
        [0,1],
        [0,-1],
        [1,0],
        [-1,0]
    ]
    visited = []
    for i in range(n):
        visited.append([float('inf')]*m)
    visited[start[0]][start[1]] = 0
    
    while queue:
        cur = queue.popleft()
        
        if map[cur[0]][cur[1]]==target:
            break
        
        for d in dir:
            rn, rc = [cur[0]+d[0], cur[1]+d[1]]
            
            if(rn<0 or rc<0 or rn>=n or rc>=m): continue
            if(map[rn][rc]=='X'): continue
            if(visited[rn][rc]!=float('inf')): continue
            queue.append([rn, rc])
            visited[rn][rc] = visited[cur[0]][cur[1]] + 1
    return visited[target[0]][target[1]] if visited[target[0]][target[1]]!=float('inf') else -1