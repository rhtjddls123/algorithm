from itertools import combinations

def solution(n, info):
    best_diff = 0
    result = [-1]

    def is_better(new, old):
        for i in range(10, -1, -1):  # 낮은 점수부터 비교
            if new[i] != old[i]:
                return new[i] > old[i]
        return False

    for r in range(1, 12):
        for combo in combinations(range(11), r):
            ryan = [0] * 11
            arrows_used = 0
            ryan_score = 0
            apeach_score = 0

            for idx in combo:
                ryan[idx] = info[idx] + 1  # 이기려면 +1발
                arrows_used += info[idx] + 1
                ryan_score += 10 - idx

            if arrows_used > n:  # 화살 초과면 스킵
                continue

            ryan[10] += n - arrows_used  # 남은 화살 0점에

            for idx in range(11):
                if idx not in combo and info[idx] > 0:
                    apeach_score += 10 - idx  # 라이언이 안 이긴 점수대는 어피치가 가져감

            diff = ryan_score - apeach_score
            if diff > best_diff or (diff == best_diff and diff > 0 and is_better(ryan, result)):
                best_diff = diff
                result = ryan[:]

    return result