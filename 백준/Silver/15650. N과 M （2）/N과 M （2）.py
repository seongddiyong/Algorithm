n,m = map(int, input().split())

temp = []
a = 1
def dfs(a):
    if len(temp) == m:
        print(' '.join(map(str,temp)))
        return
    
    for i in range(a,n+1):
        if i not in temp:
            temp.append(i)
            dfs(i)
            temp.pop()
dfs(a)