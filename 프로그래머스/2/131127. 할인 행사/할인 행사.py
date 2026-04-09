from collections import Counter
def solution(want, number, discount):
    k = 0
    for n in number:
        k+=n
        
    dict = {}
    for i in range(len(number)):
        dict[want[i]] = number[i]
        
    dLen = len(discount)
    count = 0
    for i in range(dLen-k+1):
        arr = discount[i:k+i]
        if Counter(arr)==dict:
            count += 1
        
    return count