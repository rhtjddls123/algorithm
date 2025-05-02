function solution(prices) {
    const stack = [0];
    const answer = new Array(prices.length).fill(0)
    
    for(let i=1; i<prices.length; i+=1){
        while(stack.length>0 && prices[i]<prices[stack.at(-1)]){
            const j = stack.pop()
            answer[j] = i-j;
        }
        stack.push(i)
    }
    
    while(stack.length>0){
        const j = stack.pop()
        answer[j] = prices.length-j-1;
    }
    
    return answer
}