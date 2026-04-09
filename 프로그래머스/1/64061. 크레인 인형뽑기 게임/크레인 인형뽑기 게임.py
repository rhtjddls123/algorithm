def solution(board, moves):
    n = len(board)
    stack = []
    count = 0
    for m in moves:
        for i in range(n):
            if board[i][m-1] != 0:
                v = board[i][m-1]
                if stack and stack[-1]==v:
                    stack.pop()
                    count += 1
                else:
                    stack.append(v)
                board[i][m-1] = 0
                break
    return count*2