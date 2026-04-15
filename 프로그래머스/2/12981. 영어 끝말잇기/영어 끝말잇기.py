def solution(n, words):
    round = 1
    pre = None
    dup = set()
    index = 0
    for i,w in enumerate(words):
        index = i+1
        if i==0:
            pre = w
            dup.add(w)
            continue
        
        if i%n==0: round+=1
        
        if w[0] != pre[-1]:
            break
        
        dup_size = len(dup)
        dup.add(w)
        if dup_size == len(dup):
            break
        pre = w
    
    if len(dup)==len(words):
        return [0,0]
    
    return [index-(round-1)*n, round]