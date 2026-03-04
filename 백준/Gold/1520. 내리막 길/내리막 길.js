const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const lines = [];
rl.on("line", (line) => {
  lines.push(line.trim());
});

rl.on("close", () => {
  const [N, M] = lines[0].split(" ").map(Number);

  const grid = [];
  for (let i = 1; i <= N; i++) {
    grid.push(lines[i].split(" ").map(Number));
  }

  const dir = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1]
  ];

  let count = 0;
  const dp = Array.from({ length: N }, () => Array(M).fill(-1));

  function dfs(cur) {
    if (cur[0] === M - 1 && cur[1] === N - 1) {
      return 1;
    }

    if (dp[cur[1]][cur[0]] !== -1) return dp[cur[1]][cur[0]];

    dp[cur[1]][cur[0]] = 0;
    const curVal = grid[cur[1]][cur[0]];

    for (let i = 0; i < 4; i += 1) {
      const next = [cur[0] + dir[i][0], cur[1] + dir[i][1]];

      if (next[0] >= 0 && next[0] < M && next[1] >= 0 && next[1] < N) {
        const nextVal = grid[next[1]][next[0]];
        if (nextVal < curVal) {
          dp[cur[1]][cur[0]] += dfs(next);
        }
      }
    }

    return dp[cur[1]][cur[0]];
  }

  console.log(dfs([0, 0]));
  return dfs([0, 0]);
});