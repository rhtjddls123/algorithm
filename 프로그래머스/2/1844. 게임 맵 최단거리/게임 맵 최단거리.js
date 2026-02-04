function solution(maps) {
  const n = maps.length;
  const m = maps[0].length;
  if (maps[n - 1][m - 2] === 0 && maps[n - 2][m - 1] === 0) {
    return -1;
  }

  const dx = [0, 0, -1, 1];
  const dy = [-1, 1, 0, 0];

  const queue = [];
  queue.push([0, 0]);

  while (queue.length) {
    const [x, y] = queue.shift();

    for (let i = 0; i < 4; i += 1) {
      const nx = x + dx[i];
      const ny = y + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] === 1) {
        maps[nx][ny] = maps[x][y] + 1;
        queue.push([nx, ny]);
      }
    }
  }

  return maps[n - 1][m - 1] === 1 ? -1 : maps[n - 1][m - 1];
}