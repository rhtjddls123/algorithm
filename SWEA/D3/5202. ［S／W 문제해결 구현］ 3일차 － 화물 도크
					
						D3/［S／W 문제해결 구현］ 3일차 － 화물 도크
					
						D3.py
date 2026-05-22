T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    times = []
    for _ in range(N):
        s, e = map(int, input().split())
        times.append((s, e))
    sorted_times = sorted(times, key=lambda x: x[1])
    end_time = 0
    result = 0
    for time in sorted_times:
        if end_time<=time[0]:
            result+=1
            end_time=time[1]

    print(f'#{test_case} {result}')
