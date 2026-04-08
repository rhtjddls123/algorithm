import copy

def solution(dirs):
    cur = [0,0]
    dir = {'L': [-1, 0], 'R': [1, 0], 'U': [0, 1], 'D': [0, -1]}
    result = []
    for d in dirs:
        if(possible(cur, dir[d])):
            tmp = copy.deepcopy(cur)
            cur[0] = cur[0] + dir[d][0]
            cur[1] = cur[1] + dir[d][1]
            result.append(f'{",".join(map(str,tmp))} {",".join(map(str,cur))}')
            result.append(f'{",".join(map(str,cur))} {",".join(map(str,tmp))}')
    return (len(set(result))/2)
        
def possible(cur, next):
    if (cur[0]+next[0]<-5 or cur[0]+next[0]>5 or cur[1]+next[1]<-5 or cur[1]+next[1]>5): return False
    return True