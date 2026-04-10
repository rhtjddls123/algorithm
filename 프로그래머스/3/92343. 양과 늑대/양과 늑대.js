function solution(info, edges) {
    const graph = Array.from({length: info.length}, ()=>[])
    
    for(const [from, to] of edges){
        graph[from].push(to)
    }
    
    let maxSheep = 0
    
    function dfs(sheep, wolf, candidate){
        maxSheep = Math.max(maxSheep, sheep);
        
        for(let i=0; i<candidate.length; i+=1){
            const next = candidate[i];
            
            let nextSheep = sheep;
            let nextWolf = wolf;
        
            if(info[next]===0) nextSheep+=1
            else nextWolf+=1
            
            if(nextWolf>=nextSheep) continue
            
            const nextCandidate = [...candidate];
            nextCandidate.splice(i, 1);
            nextCandidate.push(...graph[next])
            
            dfs(nextSheep, nextWolf, nextCandidate)
        }
        
        
    }
    dfs(1,0,graph[0])
    return maxSheep
}