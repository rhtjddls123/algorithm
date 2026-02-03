function solution(n, words) {
    let round = 1;
    let end = words[0].at(-1);
    let player = 1;
    const set = new Set([words[0]])
    
    for(let i=1; i<words.length; i+=1){
        player = (i%n)+1;
        round = Math.ceil((i+1)/n)
        const start = words[i][0];
        if(start!==end){
            return [player, round]
        }
        set.add(words[i]);
        if(set.size!==i+1){
            return [player, round]
        }
        end = words[i].at(-1);
    }
    
    return [0,0]
}