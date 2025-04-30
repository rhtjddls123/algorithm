function solution(answers) {
    const first = [1,2,3,4,5];
    const second = [2,1,2,3,2,4,2,5];
    const third = [3,3,1,1,2,2,4,4,5,5];
    
    const result = [0,0,0]
    for(let i=0; i<answers.length; i+=1){
        answer = answers[i];
        result[0] += answer===first[i%first.length]?1:0;
        result[1] += answer===second[i%second.length]?1:0;
        result[2] += answer===third[i%third.length]?1:0;
    }
    
    const max = Math.max(...result);
    
    const a = [];
    for(let i=0; i<result.length; i+=1){
        if(result[i]===max){
            a.push(i+1)
        }
    }
    return a
}