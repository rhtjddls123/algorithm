def solution(n):
    arr = [-1] * n
    result = 0
    def backtrack(cur):
        nonlocal result
        if cur==n: 
            result += 1
            return
        for i in range(n):
            if i in arr: continue
            
            process = True
            for j in range(cur):
                if abs(cur - j) == abs(arr[j] - i):
                    process = False
                    break
            if process:
                arr[cur] = i
                backtrack(cur+1)
                arr[cur] = -1
    backtrack(0)
    return result