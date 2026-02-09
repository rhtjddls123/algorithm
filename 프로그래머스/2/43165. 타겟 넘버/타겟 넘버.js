function solution(numbers, target) {
    return dfs(numbers, 0, 0, target);
}

function dfs(numbers, index, sum, target){
    if(numbers.length===index&&target===sum)
        return 1;
    else if(numbers.length===index)
        return 0;
    
    return dfs(numbers, index+1, sum + numbers[index], target) + dfs(numbers, index+1, sum - numbers[index], target)
}