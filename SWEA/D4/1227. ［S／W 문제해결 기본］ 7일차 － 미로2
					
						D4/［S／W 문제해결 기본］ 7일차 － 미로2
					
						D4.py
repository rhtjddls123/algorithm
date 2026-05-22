from collections import deque

for test_case in range(1, 11):
    t = int(input())
    map_arr = []
    for _ in range(100):
        map_arr.append(list(map(int, input())))
    start = None
    end = None
    for i in range(100):
        for j in range(100):
            if map_arr[i][j] == 2:
                start = (i,j)
            elif map_arr[i][j] == 3:
                end = (i,j)
            if start and end: break

    queue = deque([start])
    dir = [(0,1),(0,-1),(1,0),(-1,0)]
    visited = [[False]*100 for _ in range(100)]

    while queue:
        x, y = queue.popleft()
        visited[x][y] = True
        for d in dir:
            dx, dy = x+d[0], y+d[1]
            if 0<=dx<100 and 0<=dy<100 and map_arr[dx][dy] != 1 and not visited[dx][dy]:
                queue.append((dx, dy))
    result = 0
    if visited[end[0]][end[1]]:
        result = 1
    print(f'#{t} {result}')