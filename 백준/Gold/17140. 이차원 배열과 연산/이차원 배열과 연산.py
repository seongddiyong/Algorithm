from sys import stdin
input = stdin.readline

def cal(mat, dir):
    new_mat = []
    length = 0
    for row in mat:
        num_cnt, new_row = [], []
        for n in set(row):
            if n == 0: continue
            cnt = row.count(n)
            num_cnt.append((n, cnt))
        num_cnt = sorted(num_cnt, key = lambda x : (x[1], x[0]))
        for num, cnt in num_cnt:
            new_row += [num, cnt]
        new_mat.append(new_row)
        length = max(length, len(new_row))
    for row in new_mat:
        row += [0] * (length - len(row))
        if len(row) > 100 : row = row[:100]
    
    return list(zip(*new_mat)) if dir == 'C' else new_mat
        

r, c, k = map(int, input().split())

r -= 1
c -= 1

mat = [list(map(int, input().split())) for _ in range(3)]

time = 0
while True:
    if time > 100:
        time = -1
        break
    if 0 <= r < len(mat) and 0 <= c < len(mat[0]) and mat[r][c] == k:
        break
    if len(mat) >= len(mat[0]):
        mat = cal(mat, 'R')
    else:
        mat = cal(list(zip(*mat)), 'C')
    time += 1
print(time)