def solution(numbers, target):
    def dfs(numbers, index, sum, target):
        if index==len(numbers) and sum==target:
            return 1
        elif index==len(numbers):
            return 0
        return dfs(numbers, index+1, sum+numbers[index], target) + dfs(numbers, index+1, sum-numbers[index], target)
    
    return dfs(numbers, 0, 0, target)