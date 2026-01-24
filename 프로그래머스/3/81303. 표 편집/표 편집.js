function solution(n, k, cmd) {
  const table = createArr(n);
  const delArr = [];
  for (let i = 0; i < cmd.length; i += 1) {
    const command = cmd[i];
    const [c, m] = commandCheck(command);

    if (c === "U" || c === "D") {
      k = move(table, k, c, m);
    }

    if (c === "C") {
      k = del(table, k, delArr);
    }

    if (c === "Z") {
      z(table, delArr);
    }
  }

  let result = "";
  for (let i = 0; i < n; i += 1) {
    result += table[i].del ? "X" : "O";
  }
  return result
}

function commandCheck(command) {
  const split = command.split(" ");
  if (split[0] === "U" || split[0] === "D") {
    return [split[0], Number(split[1])];
  } else if (split[0] === "C" || split[0] === "Z") {
    return [split[0], -1];
  }
}

function createArr(n) {
  const arr = [];
  for (let i = 0; i < n; i += 1) {
    arr.push({
      prev: i === 0 ? null : i - 1,
      idx: i,
      del: false,
      next: i + 1 === n ? null : i + 1
    });
  }
  return arr;
}

function move(table, cur, dir, n) {
  // dir은 U또는 D가 들어온다

  for (let i = 0; i < n; i += 1) {
    if (dir === "U") {
      cur = table[cur].prev;
    }
    if (dir === "D") {
      cur = table[cur].next;
    }
  }

  return cur;
}

function del(table, k, delArr) {
  // k에 해당하는 del을 바꾸고 k를 옮겨야됨
  // 만약 다음에 있는것들중 del이 false인게 하나라도 있으면 아래로
  table[k].del = true;
  delArr.push(k);
  if (table[k].prev !== null) {
    table[table[k].prev].next = table[k].next;
  } else {
    table[table[k].next].prev = null;
  }
  if (table[k].next !== null) {
    table[table[k].next].prev = table[k].prev;
    k = table[k].next;
  } else {
    table[table[k].prev].next = null;
    k = table[k].prev;
  }

  return k;
}

function z(table, delArr) {
  const idx = delArr.pop();
  table[idx].del = false;
  if (table[idx].prev !== null) {
    table[table[idx].prev].next = idx;
  } else {
    table[table[idx].next].prev = idx;
  }

  if (table[idx].next !== null) {
    table[table[idx].next].prev = idx;
  } else {
    table[table[idx].prev].next = idx;
  }
}