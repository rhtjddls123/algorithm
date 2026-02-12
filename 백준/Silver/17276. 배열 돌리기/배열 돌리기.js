const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

let idx = 0;
const T = Number(input[idx++]);
let output = "";

for (let t = 0; t < T; t++) {
  const [n, d] = input[idx++].split(" ").map(Number);
  let arr = [];

  for (let i = 0; i < n; i++) {
    arr.push(input[idx++].split(" ").map(Number));
  }

  const cnt = (((d % 360) + 360) % 360) / 45;
  for (let r = 0; r < cnt; r++) {
    arr = rotate45(arr, n);
  }

  for (let row of arr) {
    output += row.join(" ") + "\n";
  }
}

console.log(output);

function rotate45(matrix, n) {
  const mid = (n - 1) / 2;
  const newMatrix = matrix.map((row) => [...row]);

  for (let i = 0; i < n; i++) {
    newMatrix[i][mid] = matrix[i][i];
    newMatrix[i][n - 1 - i] = matrix[i][mid];
    newMatrix[mid][n - 1 - i] = matrix[i][n - 1 - i];
    newMatrix[i][i] = matrix[mid][i];
  }

  return newMatrix;
}
