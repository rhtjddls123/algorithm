function solution(N, stages) {
    let P = stages.length;
    const result = new Array(N).fill(0)

    for(let i=0; i<stages.length; i+=1){
        const stage = stages[i];
        if(stage-1<N)
            result[stage-1] += 1
    }
    
    const rat = []
    for(let i=0; i<result.length; i+=1){
        rat.push([i+1,result[i]/P])
        P-=result[i]
    }
    
    rat.sort((a,b)=>b[1]-a[1])
    
    return rat.map((v)=>v[0])
}
