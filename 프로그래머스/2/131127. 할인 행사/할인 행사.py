from collections import Counter
def solution(want, number, discount):
    want_dict = dict(zip(want, number))
    count = 0
    for i in range(len(discount)-9):
        if Counter(discount[i:10+i])==want_dict:
            count += 1
        
    return count