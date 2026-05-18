from itertools import combinations
T = int(input())
for test_case in range(1, T + 1):
    N, B = map(int, input().split())
    arr = list(map(int, input().split()))
    minS = [float('inf')]
    visited = [0]*N

    def backtrack(n, s):
        if s>=B:
            minS[0] = min(minS[0], s)
            return

        for i in range(n, N):
            if minS[0]<s+arr[i] or visited[i]:
                continue
            visited[i] = 1
            backtrack(i+1, s+arr[i])
            visited[i] = 0
    backtrack(0, 0)
    print(f'#{test_case} {minS[0]-B}')
