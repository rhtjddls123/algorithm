function solution(numbers) {
    const arr=[]
    for(let i=0; i<numbers.length-1; i+=1){
        for(let j=i+1; j<numbers.length; j+=1){
            arr.push(numbers[i]+numbers[j])
        }
    }
    
    const setArr = [...new Set(arr)];
    const sortedArr = setArr.sort((a,b)=>a-b);
    return sortedArr;
}