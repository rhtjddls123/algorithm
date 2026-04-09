import math
from collections import deque

def solution(progresses, speeds):
    queue = deque()
    for i in range(len(progresses)):
        queue.append(math.ceil((100-progresses[i])/speeds[i]))
        
    start = None
    count = 0
    result = []
    while(queue):
        if(start==None):
            start = queue.popleft()
            count += 1
            continue
        if(start>=queue[0]):
            queue.popleft()
            count += 1
        else:
            result.append(count)
            start=None
            count=0
    result.append(count)
    return result
    