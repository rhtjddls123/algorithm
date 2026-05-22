from collections import deque

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    room = [list(map(int, input().split())) for _ in range(N)]
    pos = [None] * (N*N + 1)
    dp = [[1]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            pos[room[i][j]] = (i, j)

    dir = [(0,1), (0,-1), (1,0), (-1,0)]
    for i in range(N*N, 0, -1):
        x, y = pos[i]
        for d in dir:
            dx, dy = x+d[0], y+d[1]
            if 0<=dx<N and 0<=dy<N and i+1 == room[dx][dy]:
                dp[x][y] = dp[dx][dy] + 1
    best_num = 1
    best_cnt = 1
    for i in range(N):
        for j in range(N):
            if dp[i][j] > best_cnt or (dp[i][j] == best_cnt and room[i][j] < best_num):
                best_cnt = dp[i][j]
                best_num = room[i][j]
    print(f'#{test_case} {best_num} {best_cnt}')