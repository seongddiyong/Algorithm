def solution(progresses, speeds):
    temp = []
    answer = []
    for i in range(len(speeds)):
        if (100 - progresses[i]) % speeds[i]: temp.append((100 - progresses[i]) // speeds[i] + 1)
        else: temp.append((100 - progresses[i]) // speeds[i])
    temp.append(101)
    st = temp[0]
    cnt = 1
    for i in range(1,len(temp)):
        if temp[i] <= st:
            cnt += 1
        else:
            answer.append(cnt)
            st = temp[i]
            cnt = 1
    return answer