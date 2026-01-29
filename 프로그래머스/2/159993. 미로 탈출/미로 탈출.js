function solution(maps) {
    const map = [];
    for(const m of maps){
        map.push(m.split(''))
    }
    
    let lever
    for(let i=0; i<map.length; i+=1){
        for(let j=0; j<map[i].length; j+=1){
            if(map[i][j]==='L') lever = [i, j]
        }
    }
    const a = bfs(lever, 'S', map);
    const b = bfs(lever, 'E', map);
    if(a<0 || b<0) return -1
    return a+b
}

function bfs(start, target, map){
    const queue = [[...start, 0]];
    const visited = Array.from({length: map.length}, ()=>Array(map[0].length).fill(false))
    visited[start[0]][start[1]] = true
    const xd = [ -1, 1, 0, 0 ]
    const yd = [ 0, 0, -1, 1 ]
    
    while(queue.length){
        const [x, y, dist] = queue.shift();
        
        if(map[x][y]===target) return dist;
        
        for(let i=0; i<4; i+=1){
            const dx = x + xd[i];
            const dy = y + yd[i];
            
            if(
                (dx>=0 && dx<map.length) &&
                (dy>=0 && dy<map[0].length) &&
                map[dx][dy] !== 'X' &&
                !visited[dx][dy]
              ){
                visited[dx][dy] = true;
                queue.push([dx, dy, dist+1])
            }
        }
    }
    return -1
}
