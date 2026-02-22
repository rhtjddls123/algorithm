function solution(citations) {
    citations.sort((a,b)=>b-a);
    const length = citations.length
    let result = 0;
    
    for(let i=0; i<length; i+=1){
        const h = citations[i];
        if(i+1<=h){
            result = i+1
        }
    }
    
    return result
}