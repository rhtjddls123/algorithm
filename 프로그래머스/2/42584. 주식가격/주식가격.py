def solution(prices):
    answer = [0] * len(prices)
    stack = []
    for i in range(len(prices)):
        price = prices[i]
        while True:
            if(stack and prices[stack[-1]]<= price or not stack): break
            s = stack.pop()
            answer[s] = i - s
        stack.append(i)
    
    while stack:
        s = stack.pop()
        answer[s] = len(prices) - s - 1
    return answer