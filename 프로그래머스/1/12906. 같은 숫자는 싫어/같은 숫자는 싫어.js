function solution(arr) {
    const result = []
    for(const i of arr){
        if(result.length===0){
            result.push(i)
            continue;
        }
        
        const p = result[result.length-1];
        if(i===p){
            continue;
        }
        result.push(i)
    }
    
    return result;
}