function solution(n,a,b)
{
    let count = 1;
    while(true){
        if(Math.abs(a-b)===1 && Math.max(a,b)%2===0){
            return count;
        }
        count += 1
        if(a%2===0) a /= 2
        else a = (a+1)/2
        
        if(b%2===0) b /= 2
        else b = (b+1)/2
    }

}