function solution(n, wires) {
    const graph = Array.from({length: n+1},()=>[]);
    for(const [a,b] of wires){
        graph[a].push(b);
        graph[b].push(a);
    }
    
    function dfs(node, parent) {
        let cnt = 1;
        for(const child of graph[node]){
            if(child !== parent){
                cnt+=dfs(child, node);
            }
        }
        return cnt;
    }
    let result = Infinity;
    for(let i=0; i<wires.length; i+=1){
        const [a,b] = wires[i];
        graph[a].splice(graph[a].indexOf(b), 1);
        graph[b].splice(graph[b].indexOf(a), 1);
        
        const cntA = dfs(a,b);
        const cntB = n - cntA;
        
        result = Math.min(result, Math.abs(cntA-cntB))
        
        graph[a].push(b);
        graph[b].push(a);
    }
    
    return result
}

