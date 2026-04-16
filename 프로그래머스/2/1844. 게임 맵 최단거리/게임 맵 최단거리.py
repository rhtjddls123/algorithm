from collections import deque

def solution(maps):
    queue = deque()
    queue.append([0,0])
    dir = [[0,1], [0,-1], [1,0], [-1,0]]
    n = len(maps)-1
    m = len(maps[0])-1
    while queue:
        cur = queue.popleft()
        for d in dir:
            dx, dy = cur[0] + d[0], cur[1] + d[1]
            if dx>n or dy>m or dx<0 or dy<0 or maps[dx][dy]!=1:
                continue
            maps[dx][dy] += maps[cur[0]][cur[1]]
            queue.append([dx, dy])
    print(maps)
    if maps[n][m] == 1:
        return -1
    return maps[n][m]