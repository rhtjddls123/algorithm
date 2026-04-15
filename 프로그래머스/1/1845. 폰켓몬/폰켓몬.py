def solution(nums):
    result = len(set(nums)) if int(len(nums)/2)>len(set(nums)) else int(len(nums)/2)
    return result
