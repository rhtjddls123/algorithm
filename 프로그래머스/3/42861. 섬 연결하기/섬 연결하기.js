function solution(n, costs) {
  costs.sort((a, b) => a[2] - b[2]);
  const arr = Array.from({ length: n }, (_, i) => ({ cost: 0, root: i }));
  let cost = 0;

  for (let i = 0; i < costs.length; i += 1) {
    if (union(arr, costs[i][0], costs[i][1])) {
      cost += costs[i][2];
    }
  }

  return cost
}

function union(arr, x, y) {
  const xr = find(arr, x);
  const yr = find(arr, y);

  arr[yr].root = arr[xr].root;
  return xr !== yr;
}

function find(arr, x) {
  let cur = x;
  while (cur !== arr[cur].root) {
    cur = arr[cur].root;
  }
  return cur;
}