def solution(keymap, targets):
    answer = []
    dict = {}
    for i in keymap:
        for idx, j in enumerate(i):
            if j in dict:
                if idx+1 < dict[j]:
                    dict[j] = idx+1
            else:
                dict[j] = idx+1
    for i in targets:
        cnt = 0
        for j in i:
            if j not in dict:
                cnt = -1
                break
            else:
                cnt += dict[j]
        answer.append(cnt)
    return answer