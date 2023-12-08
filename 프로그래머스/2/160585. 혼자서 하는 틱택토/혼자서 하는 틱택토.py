from itertools import combinations

def correct(board, t):
    for row in board:
        if row == [t, t, t]: return True
    for col in range(3):
        if [board[row][col] for row in range(3)] == [t, t, t]: return True
    if [board[0][0], board[1][1], board[2][2]] == [t, t, t]: return True
    if [board[2][0], board[1][1], board[0][2]] == [t, t, t]: return True
    return False

def solution(board):
    board = [list(row) for row in board]
    cnto = cntx = 0
    for i in board:
        for j in i:
            if j == 'O':
                cnto += 1
            elif j == 'X':
                cntx += 1
    if not (cnto == cntx or cnto == cntx + 1): return 0
    if correct(board,'O') and correct(board,'X'): return 0
    if correct(board, 'O') and cnto != cntx + 1: return 0
    if correct(board, 'X') and cnto != cntx: return 0
    return 1
    