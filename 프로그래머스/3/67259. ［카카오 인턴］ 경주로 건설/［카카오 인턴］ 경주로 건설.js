function solution(board) {
  const dir = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1]
  ];
  let q;
  const n = board.length;
  const visited = Array.from({ length: n }, () =>
    Array.from({ length: n }, () => ({ h: Infinity, v: Infinity }))
  );
  const queue = [{ cur: [0, 0], cost: 0, d: null }];
  while (queue.length > 0) {
    queue.sort((a, b) => a.cost - b.cost);
    q = queue.shift();
    for (let i = 0; i < 4; i += 1) {
      const cur = [q.cur[0] + dir[i][0], q.cur[1] + dir[i][1]];
      if (cur[0] >= board.length || cur[0] < 0 || cur[1] >= board.length || cur[1] < 0) continue;

      const nextD = nextDir(q.cur, cur);
      const cost = isCorner(q.d, nextD) ? q.cost + 600 : q.cost + 100;

      if (board[cur[0]][cur[1]] === 1) continue;
      if (visited[cur[0]][cur[1]][nextD] <= cost) continue;
      queue.push({ cur, cost, d: nextD });
      visited[cur[0]][cur[1]][nextD] = cost;
    }
  }
  return Math.min(visited[n - 1][n - 1].v, visited[n - 1][n - 1].h);
}

function isCorner(d, nd) {
  if (d === "h" && nd === "v") return true;
  if (d === "v" && nd === "h") return true;
  return false;
}

function nextDir(prev, cur) {
  if (Math.abs(prev[0] - cur[0]) === 1 && Math.abs(prev[1] - cur[1]) === 0) return "v";
  if (Math.abs(prev[0] - cur[0]) === 0 && Math.abs(prev[1] - cur[1]) === 1) return "h";
}