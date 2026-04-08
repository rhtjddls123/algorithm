def solution(s):
    count = 0
    s = list(x for x in s)
    for i in range(len(s)):
        if correct(s): count += 1
        tmp = s.pop(0)
        s.append(tmp)
    return count

def correct(s):
    dict = { ')':'(', ']':'[', '}':'{' }
    push = [ '(', '[', '{' ]
    stack = []
    for i in s:
        if i in push:
            stack.append(i)
        else:
            if(len(stack)==0): return False
            pop = stack.pop()
            if(dict[i]!=pop):
                return False
    return len(stack)==0