function solution(dirs) {
    let x = 0;
    let y = 0;
    const visited = new Set();
    
    for(let i=0; i<dirs.length; i+=1){
        const dir = dirs[i];
        const [nx, ny] = move(x,y,dir);
        
        if(!isMoveable(nx,ny)){
            continue;
        }
        
        visited.add(`${x}${y}${nx}${ny}`)
        visited.add(`${nx}${ny}${x}${y}`)
        
        x = nx;
        y = ny
    }
    
    return visited.size / 2
}

function move(x,y,dir){
    if(dir==='U'){
        return [x,y+1]
    }
    if(dir==='D'){
        return [x,y-1]
    }
    if(dir==='L'){
        return [x-1,y]
    }
    if(dir==='R'){
        return [x+1,y]
    }
}

function isMoveable(x,y){
    return x>=-5 && x<=5 && y<=5 && y>=-5
}