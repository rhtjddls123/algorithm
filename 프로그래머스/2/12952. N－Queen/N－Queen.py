def solution(n):
    result = 0
    queens = [-1] * n
    def backtrack(cur):
        nonlocal result
        if cur==n:
            result += 1
            return
        
        for i in range(n):
            if i in queens: continue
            
            process = True
            for j in range(cur):
                if abs(j-cur)==abs(queens[j]-i):
                    process = False
                    break
            if process:
                queens[cur] = i
                backtrack(cur + 1)
                queens[cur] = -1
    backtrack(0)
    return result