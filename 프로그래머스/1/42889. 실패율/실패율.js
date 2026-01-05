function solution(N, stages) {
    const rate = {}
    for(let i=1; i<=N; i+=1){
        let allPlayers = 0
        for(let j=0; j<stages.length; j+=1){
            if(stages[j]>=i) allPlayers+=1;
        }
        
        if(allPlayers===0) {
            rate[i] = 0;
            continue;
        }
        
        const failPlayers = stages.filter(a=>a===i).length;
        rate[i] = failPlayers/allPlayers;
    }
    
    const result = Object.entries(rate).sort((a,b)=>b[1]-a[1])
    return result.map(v=>Number(v[0]))
}

// 실패율 = 스테이지에서 클리어 못한 플레이어 수 / 스테이지 도달 플레이어 수
// N = 스테이지 개수, stages = 사용자가 현재 멈춰있는 스테이지 배열

// 특정 스테이지의 실패율 구하기
// 1. 특정 스테이지에 도달한 플레이어 수를 먼저 구함
//    그러기 위해서는 특정 스테이지보다 사용자의 스테이지가 큰 값을 모두 구하기
//    예를들어 1스테이지의 총 도달 플레이어 수는 stages배열에서 1보다 크거나 같은 값들의 개수
//    만약 도달한 플레이어가 없으면 실패율은 바로 0
// 2. 스테이지에서 클리어 못한 플레이어의 수 구하기
//    해당 값은 특정 스테이지의 사용자 수를 구하면 됨
//    예를들어 1스테이지를 클리어 못한 플레이어는 stages배열에서 1인 값들의 개수
// 3. 해당 실패율을 각각의 값에 저장 후 높은 순서대로 스테이지를 반환하기