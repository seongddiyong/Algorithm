def solution(babbling):
    answer = 0
    for i in babbling:
        for j in ["aya", "ye", "woo", "ma"]:
            i = i.replace(j,".")
            if ".." in i:
                break
            else:
                i = i.replace(".","*")
        else:
            i = i.replace("*","")
        if len(i) == 0:
            answer += 1
    return answer