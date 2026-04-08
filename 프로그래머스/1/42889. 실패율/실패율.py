def solution(N, stages):
    c = len(stages)
    s = list(0 for _ in range(N))
    result = []
    for (i, v) in enumerate(stages):
        if(v>N): continue
        s[v-1] += 1
    
    for (i, v) in enumerate(s):
        if(c==0): result.append([i+1, 0])
        else: result.append([i+1, v/c])
        c -= v
    result.sort(key=lambda x:x[1], reverse=True)
    return list(i[0] for i in result)