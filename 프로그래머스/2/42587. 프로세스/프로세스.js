function solution(priorities, location) {
    let c = 0;
    
    const arr = Array.from({length: priorities.length}, (v,i)=>[i, priorities[i]]);
    while(true){
        const q = arr.shift();
        
        let process = true;
        for(let i=0; i<arr.length; i+=1){
            if(arr[i][1]>q[1]){
                process=false;
                arr.push(q);
                break;
            }
        }
        
        if(process){
            c+=1
        }
        
        if(q[0]===location && process){
            return c
        }
    }
}