function solution(n, computers) {
    const visited = {};
    const stack = [];
    let count = 0;
    
    for(let i=0; i<n; i+=1){
        if(!visited[i]){
            count+=1;
            stack.push(i);
        }
        
        while(true){
            if(stack.length===0){
                break;
            }
            const nextNode = stack.pop();
            visited[nextNode] = true;
            for(let j=0; j<n; j+=1){
                if(!visited[j]&&computers[nextNode][j]===1){
                    stack.push(j);
                    visited[j] = true;
                }
            }
        }
    }
    return count
}