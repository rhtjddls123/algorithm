from itertools import combinations
from collections import Counter

def solution(orders, course):
    result = []
    for c in course:
        counter = Counter()
        
        for order in orders:
            for combo in combinations(sorted(order), c):
                counter[''.join(combo)] += 1
        
        if not counter: continue
        
        max_count = max(counter.values())
        
        if max_count>=2:
            for menu in counter.items():
                if menu[1]==max_count:
                    result.append(menu[0])
    return sorted(result)