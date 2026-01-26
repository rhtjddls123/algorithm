function solution(genres, plays) {
    var answer = [];
    const genresPlays = {};
    const genresIdxs = {}
    const result = []
    
    for(let i=0; i<genres.length; i+=1){
        const [genre, count] = [genres[i], plays[i]]
        genresPlays[genre] = genresPlays[genre] ? genresPlays[genre]+count : count;
        
        if(genresIdxs[genre]){
            genresIdxs[genre].push([i, count])
        }else{
            genresIdxs[genre] = [[i, count]]
        }
    }
    const genresPlaysSortedArr = Object.entries(genresPlays).sort((a,b)=>b[1]-a[1])
    
    for(let i=0; i<genresPlaysSortedArr.length; i+=1){
        const genre = genresPlaysSortedArr[i][0];
        const sortedPlay = genresIdxs[genre].sort((a,b)=>b[1]-a[1] || a[0]-b[0])
        
        const c = sortedPlay.length>=2?2:sortedPlay.length;
        for(let j=0; j<c; j+=1){
            result.push(sortedPlay[j][0])
        }
    }
    
    return result;
}