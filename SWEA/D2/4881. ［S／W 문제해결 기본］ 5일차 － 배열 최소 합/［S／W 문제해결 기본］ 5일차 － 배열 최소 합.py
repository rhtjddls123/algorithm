from itertools import combinations
T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    result = [float('inf')]

    def backtrack(n, s, r):
        if len(s)==N:
            result[0] = min(result[0], sum(s))
            return
        if sum(s)>=result[0]:
            return

        for i in range(0, N):
            if i in r: continue
            s.append(arr[n][i])
            r.append(i)
            backtrack(n+1, s, r)
            s.pop()
            r.pop()
    backtrack(0, [], [])
    print(f'#{test_case} {result[0]}')
