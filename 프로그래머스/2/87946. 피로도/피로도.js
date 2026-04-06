function solution(k, dungeons) {
    const visited = Array.from({length: dungeons.length}, ()=>0);
    
    function backtracking(curK, cnt){
        let max = cnt;
        for(let i=0; i<visited.length; i+=1){
            if(visited[i]===1 || dungeons[i][0]>curK) continue;
            
            visited[i] = 1;
            max = Math.max(max, backtracking(curK-dungeons[i][1], cnt+1));
            visited[i] = 0;
        }
        return max;
    }
    
    const max = backtracking(k, 0);
    return max;
}