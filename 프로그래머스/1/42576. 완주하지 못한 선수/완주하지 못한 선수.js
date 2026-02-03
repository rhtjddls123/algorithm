function solution(participant, completion) {
    const pObj = {}
    for(const p of participant){
        pObj[p] = pObj[p]!==undefined ? pObj[p]+1 : 0
    }
    
    for(const c of completion){
        pObj[c] -= 1
    }
    
    for(const [k,v] of Object.entries(pObj)){
        if(v===0){
            return k
        }
    }
}