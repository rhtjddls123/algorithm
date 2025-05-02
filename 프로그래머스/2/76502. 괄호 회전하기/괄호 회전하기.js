function solution(s) {
    let count = 0;
    const arr = s.split('')
    for(let i=0; i<s.length-1; i+=1){
        if(i>0) changeArr(arr);
        if(isTrue(arr)) count+=1;
    }
    
    return count
}

function changeArr(arr){
    const tmp = arr[0];
    arr.push(tmp);
    arr.shift();
}

function isTrue(input){
    if(input.length%2!==0) return false
    const match = {'(':')','[':']','{':'}'}
    const stack = []
    for(let i=0; i<input.length; i+=1){
        const c = input[i]
        if(c==='('||c==='['||c==='{'){
            stack.push(c)
        }
        
        if(c===')'||c===']'||c==='}'){
            if(stack.length===0) return false;
            
            if(c!==match[stack.pop()]) return false
        }
        
        
    }
    
    return true
}