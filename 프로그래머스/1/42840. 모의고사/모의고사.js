function solution(answers) {
    const first = [1,2,3,4,5];
    const second = [2,1,2,3,2,4,2,5];
    const third = [3,3,1,1,2,2,4,4,5,5];
    
    const score = [0,0,0];
    
    for(let i=0; i<answers.length; i+=1){
        const answer = answers[i];
        score[0] += first[i%first.length]===answer?1:0
        score[1] += second[i%second.length]===answer?1:0
        score[2] += third[i%third.length]===answer?1:0
    }
    
    const max = Math.max(...score);
    const result = [];
    
    for(let i=0; i<score.length; i+=1){
        if(score[i]===max) result.push(i+1)
    }
    
    return result;
}
// 현재 문제의 정답이 각 찍는 방식에 부합하면 1씩 더해야됨

// 1,2,3번 수포자가 찍는 방식이 모두 다름
// 정답에 대해 1,2,3번이 각각 몇개씩 맞췄나 저장 후, 비교해야 함
// 그렇다면 각 수포자에 대해 index별로 정답인지를 확인해볼까?
// 예를들어 1번 수포자는 index값이 0,5,10,15... 처럼 index%5=0일 때 answers[index] = 1이면 정답
// 근데 문제 수가 그리 많지 않아서 그냥 for문을 돌리면서 확인해도 될거같긴 한데..