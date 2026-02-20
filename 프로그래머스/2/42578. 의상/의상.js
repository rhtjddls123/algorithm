function solution(clothes) {
    const obj = {};
    for(const c of clothes){
        obj[c[1]] = obj[c[1]] ? [...obj[c[1]], c[0]] : [c[1]]
    }
    
    let result = 1;
    for(const [k,v] of Object.entries(obj)){
        result = result * (v.length + 1);
    }
    
    return result - 1
}