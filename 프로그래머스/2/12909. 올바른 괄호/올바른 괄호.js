function solution(s){
    const stack = [];
    
    for(const i of s){
        if(i==="("){
            stack.push(i)
            continue;
        }
        if(i===")" && stack.length>0){
            stack.pop();
        }
        else if(i===")" && stack.length===0){
            return false;
        }
    }
    
    return stack.length===0
}