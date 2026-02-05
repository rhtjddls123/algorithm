function solution(N, road, K) {
    road.sort((a,b)=>b[2]-a[2])
    const arr = Array.from({length:N},(fv,fi)=>Array.from({length:N},(v,i)=>fi===i?-1:0))
    const vArr = Array.from({length:N},(_,i)=>(i===0?0:Infinity))
    const visited = {}
    
    for(const r of road){
        arr[r[0]-1][r[1]-1] = r[2];
        arr[r[1]-1][r[0]-1] = r[2];
    }
    
    const queue = [0];
    while(queue.length){
        const cur = queue.shift();
        visited[cur] = true;
        for(let i=0; i<N; i+=1){
            if(arr[cur][i]>0){
                const newValue = vArr[cur]+arr[cur][i]
                
                if(vArr[i]>newValue){
                    queue.push(i);
                    vArr[i] = newValue
                }
            }
        }
    }
    
    return vArr.filter(v=>v<=K).length;
}