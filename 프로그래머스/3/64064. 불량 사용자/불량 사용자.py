def solution(user_id, banned_id):
    res = []
    for b in banned_id:
        temp = []
        for u in user_id:
            if len(u) == len(b):
                for i in range(len(u)):
                    if u[i] != b[i] and b[i] != '*':
                        break
                else:
                    temp.append(u)
        res.append(temp)
    
    ans = []
    
    def dfs(answers, lv):
        if lv == len(banned_id):
            ans.append(answers)
            return

        for value in res[lv]:
            if value not in answers:
                answers.append(value)
                dfs(answers[:], lv + 1)
                answers.pop()

    dfs([], 0)
    
    return len(set(''.join(sorted(x)) for x in ans))