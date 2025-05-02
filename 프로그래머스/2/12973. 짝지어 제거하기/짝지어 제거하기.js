function solution(s) {
    if (s.length%2!==0) return 0
    let tmp;
    const stack = []
    for(const i of s){
        if(tmp===i){
            stack.pop()
            tmp = stack.at(-1)
            continue
        }
        
        stack.push(i);
        tmp = i;
    }
    
    if(stack.length>0) return 0
    return 1
}