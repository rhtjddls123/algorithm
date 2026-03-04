function solution(k, dungeons) {
  const visited = Array.from({ length: dungeons.length }).fill(0);

  function backtrack(curK, cnt) {
    let max = cnt;

    for (let i = 0; i < dungeons.length; i += 1) {
      if (dungeons[i][0] <= curK && visited[i] === 0) {
        visited[i] = 1;

        max = Math.max(max, backtrack(curK - dungeons[i][1], cnt + 1));

        visited[i] = 0;
      }
    }

    return max;
  }

  let max = backtrack(k, 0);
  return max;
}