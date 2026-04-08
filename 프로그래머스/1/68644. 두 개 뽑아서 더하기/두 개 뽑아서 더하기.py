def solution(numbers):
    l = len(numbers)
    result = []
    for i in range(l):
        for j in range(i+1, l):
            result.append(numbers[i]+numbers[j])
    result = sorted(set(result))
    return result