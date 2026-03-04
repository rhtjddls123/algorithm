function solution(n) {
  const queens = Array.from({ length: n }).fill(-1);
  let result = 0;
    
  function backtrack(cur, queens) {
    if (cur === n) {
      if (!queens.includes(-1)) result += 1;
      return;
    }
    for (let i = 0; i < n; i += 1) {
      const q = i;

      if (queens.includes(q)) {
        // 현재 두려는 행에 있을 경우
        continue;
      }

      let process = true;

      for (let j = 0; j <= cur; j += 1) {
        if (Math.abs(j - cur) === Math.abs(queens[j] - i)) {
          process = false;
          break;
        }
      }

      if (!process) continue;

      queens[cur] = i;
      backtrack(cur + 1, queens);
      queens[cur] = -1;
    }
  }
    
  backtrack(0, queens);
  return result
}