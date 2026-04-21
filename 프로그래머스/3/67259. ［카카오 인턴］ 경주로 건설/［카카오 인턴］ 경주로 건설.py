from collections import deque

def solution(board):
    n = len(board)
    queue = deque([{'cur': [0,0], 'cost': 0, 'd': None}])
    visited = [[{'v': float('inf'), 'h': float('inf')} for _ in range(n)] for _ in range(n)]
    dir = [(0,1),(0,-1),(1,0),(-1,0)]
    while queue:
        q = queue.popleft()
        for d in dir:
            cur = [q['cur'][0] + d[0], q['cur'][1] + d[1]]
            if (cur[0] >= n or cur[0] < 0 or cur[1] >= n or cur[1] < 0): continue

            nextD = nextDir(q['cur'], cur)
            cost = q['cost'] + 600 if isCorner(q['d'], nextD) else q['cost'] + 100

            if (board[cur[0]][cur[1]] == 1): continue
            if (visited[cur[0]][cur[1]][nextD] <= cost): continue
            queue.append({ 'cur':cur, 'cost':cost, 'd': nextD })
            visited[cur[0]][cur[1]][nextD] = cost
    return min(visited[n - 1][n - 1]['v'], visited[n - 1][n - 1]['h'])

def isCorner(d, nd):
    if (d == "h" and nd == "v"): return True
    if (d == "v" and nd == "h"): return True
    return False

def nextDir(prev, cur):
    if (abs(prev[0] - cur[0]) == 1 and abs(prev[1] - cur[1]) == 0): return "v"
    if (abs(prev[0] - cur[0]) == 0 and abs(prev[1] - cur[1]) == 1): return "h"
