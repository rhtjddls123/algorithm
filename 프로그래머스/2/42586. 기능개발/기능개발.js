function solution(progresses, speeds) {
    const dayArr = []
    for(let i=0; i<progresses.length; i+=1){
        dayArr.push(Math.ceil((100-progresses[i])/speeds[i]))
    }
    console.log(dayArr)
    let n = dayArr.shift();
    let c = 1;
    const result = []
    while(dayArr.length){
        const d = dayArr.shift();
        if(n<d){
            result.push(c)
            n=d;
            c=1;
            continue;
        }
        c+=1;
    }
    
    result.push(c)
    return result
}