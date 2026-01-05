function solution(numbers) {
    let num;
    const result = []
    for(let i=0; i<numbers.length-1; i+=1){
        for(let j=i+1; j<numbers.length; j+=1){
            num = numbers[i]+numbers[j]
            result.push(num)
        }
    }
    
    return [...new Set(result)].sort((a,b)=>a-b)
}

// 정수 배열이 주어진다
// 해당 배열에서 서로 다른 인덱스의 두 수를 뽑는다
// 두 수를 더해 만들 수 있는 모든 수를 새 배열에 오름차순으로 담는다

// 어떤 수가 나올지는 모르기 때문에 모든 인덱스 쌍을 확인해야할것으로 보임
// 이중 for문을 사용하여 비교
// 대신에 내부 for문의 시작 index는 외부 for문의 다음