function solution(people, limit) {
    people.sort((a,b)=>a-b);
    let lp = 0;
    let rp = people.length - 1;
    let c = 0
    
    while(true){
        if(lp===rp){
            c+=1
            break;
        }
        if(lp>rp){
            break;
        }
        const lpv = people[lp];
        while(true){
            const rpv = people[rp];
            if(lpv+rpv<=limit || lp>=rp){
                break;
            }
            rp -= 1;
            c += 1;
        }
        
        lp += 1;
        rp -= 1;
        c += 1;
    }
    
    return c
}