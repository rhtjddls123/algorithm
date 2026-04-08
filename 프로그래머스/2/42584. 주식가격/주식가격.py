def solution(prices):
    result = list(0 for _ in range(len(prices)))
    stack = []
    
    for (i, v) in enumerate(prices):
        while stack and stack[-1][1]>v:
            tmp = stack.pop()
            result[tmp[0]] = i-tmp[0]
        stack.append([i,v])
        
    l = len(prices)-1
    for i in range(len(stack)-1,-1,-1):
        result[stack[i][0]] = l-stack[i][0]
    return result