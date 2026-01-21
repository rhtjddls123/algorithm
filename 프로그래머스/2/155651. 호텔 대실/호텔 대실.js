function solution(book_time) {
    book_time.sort((a, b) => {
    return changeTimeToIndex(a)[0] - changeTimeToIndex(b)[0];
});
    const rooms = [];
    
    for(let i=0; i<book_time.length; i+=1){
        const time = book_time[i];
        const timeIdx = changeTimeToIndex(time);
        let complete = false
        
        for(let j=0; j<rooms.length; j+=1){
            const check = checkBook(rooms[j], timeIdx);
            
            if(check){
                // 예약 가능 해당 index를 1로 변경
                rooms[j].fill(1, timeIdx[0], timeIdx[1]);
                
                complete = true;
                break;
            }else{
                // 예약 불가능 다음 배열 확인
                continue;
            }
        }
        
        if(!complete){
            // 새로 방을 만들고 해당 index를 1로 변경
            const newRoom = createRoom();
            newRoom.fill(1, timeIdx[0], timeIdx[1]);
            rooms.push(newRoom)
        }
    }
    
    return rooms.length
}

function createRoom(){
    const room = new Array(1440).fill(0);
    return room
}

function checkBook(room, timeIdx){
    const [startIdx, endIdx] = timeIdx;
    const checkTime = room.slice(startIdx, endIdx);
    
    return !checkTime.includes(1);
}

function changeTimeToIndex(time){
    const [strStartTime, strEndTime] = time
    const startTime = strStartTime.split(":")
    const startIndex = Number(startTime[0])*60 + Number(startTime[1])
    
    const endTime = strEndTime.split(":")
    const endIndex = Number(endTime[0])*60 + Number(endTime[1]) + 10
    
    return [startIndex, endIndex];
}