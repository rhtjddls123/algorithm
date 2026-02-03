function solution(participant, completion) {
    const pObj = {}
    for(const p of participant){
        pObj[p] = pObj[p] ? pObj[p]+1 : 1
    }
    
    for(const c of completion){
        pObj[c] -= 1
    }
    
    for(const [k,v] of Object.entries(pObj)){
        if(v===1){
            return k
        }
    }
}