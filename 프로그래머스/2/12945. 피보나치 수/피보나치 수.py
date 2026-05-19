import sys
sys.setrecursionlimit(1000000)

memo = {0: 0, 1: 1}

def fibonacci(n):
    if n in memo:
        return memo[n]
    result = fibonacci(n-1) + fibonacci(n-2)
    memo[n] = result
    return result

def solution(n):
    answer = fibonacci(n) % 1234567
    return answer