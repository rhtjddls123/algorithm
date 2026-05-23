for _ in range(10):
    test_case = int(input())
    n = 100
    nums = [list(map(int, input().split())) for _ in range(n)]
    a, b, c = 0, 0, 0
    for r in nums:
        a = max(a, sum(r))
    for i in range(n):
        tmp = 0
        for j in range(n):
            tmp += nums[j][i]
        b = max(b, tmp)

    tmp_a = 0
    tmp_b = 0
    for i in range(n):
        for j in range(n):
            if i==j: tmp_a+=nums[i][j]
            if i+j==n-1: tmp_b+=nums[i][j]
    c = max(tmp_a, tmp_b)
    print(f'#{test_case} {max(a,b,c)}')