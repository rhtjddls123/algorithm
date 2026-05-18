from collections import defaultdict

for test_case in range(1, 11):
    T = int(input())
    map_arr = [list(map(int, input().split())) for _ in range(100)]
    goal = map_arr[99].index(2)
    dir = [(0,1),(0,-1),(-1,0)]
    visited = [[False] * 100 for _ in range(100)]

    stack = [(99, goal)]
    result = -1
    while stack:
        x, y = stack.pop()
        if x==0:
            result = y
            break
        if visited[x][y]: continue

        visited[x][y] = True
        for d in dir:
            dx, dy = x+d[0], y+d[1]

            if 0<=dx<100 and 0<=dy<100 and map_arr[dx][dy]!=0 and not visited[dx][dy]:
                stack.append((dx, dy))
                break

    print(f'#{T} {result}')

