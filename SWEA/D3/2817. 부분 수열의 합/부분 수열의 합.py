from itertools import combinations
T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    num_arr = sorted(list(map(int, input().split())))
    result = 0

    for i in range(1, N):
        for combi in combinations(num_arr, i):
            if sum(combi) == K: result+=1
    print(f'#{test_case} {result}')