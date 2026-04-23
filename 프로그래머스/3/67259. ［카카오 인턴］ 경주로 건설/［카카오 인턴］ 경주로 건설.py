import heapq

def solution(board):
    n = len(board)
    costs = [[{'v':float('inf'), 'h':float('inf')} for _ in range(n)] for _ in range(n)]
    costs[0][0]['v'] = 0
    costs[0][0]['h'] = 0
    dir = [(1,0,'h'), (-1,0,'h'), (0,1,'v'), (0,-1,'v')]
    queue = [(0, 0, 0, None)]
    
    while queue:
        cur_cost, x, y, d = heapq.heappop(queue)
        
        for dx, dy, nd in dir:
            nx, ny = x+dx, y+dy
            if nx<0 or nx>=n or ny<0 or ny>=n or board[nx][ny]==1: continue
            next_cost = cur_cost+600 if d and d!=nd else cur_cost + 100
            if next_cost<costs[nx][ny][nd]:
                costs[nx][ny][nd] = next_cost
                heapq.heappush(queue, (next_cost, nx, ny, nd))
                
    return min(costs[n-1][n-1]['h'], costs[n-1][n-1]['v'])