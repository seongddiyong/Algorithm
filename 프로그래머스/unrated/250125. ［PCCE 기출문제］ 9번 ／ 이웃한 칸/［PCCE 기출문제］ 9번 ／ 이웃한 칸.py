def solution(board, h, w):
    answer = 0
    for i,j in [(1,0),(0,1),(-1,0),(0,-1)]:
        nh, nw = h+i, w+j
        if 0 <= nh < len(board) and 0 <= nw < len(board[0]) and board[h][w] == board[nh][nw]:
            answer += 1
    return answer