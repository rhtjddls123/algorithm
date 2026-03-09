function solution(tickets) {
  const obj = {};
  const result = ["ICN"];
  for (const ticket of tickets) {
    const from = ticket[0];
    const to = ticket[1];

    if (obj[from]) {
      obj[from].push(to);
    } else {
      obj[from] = [to];
    }

    obj[from].sort();
  }

  const results = [];

  function dfs(obj, from) {
    const copyObj = JSON.parse(JSON.stringify(obj));

    if (result.length === tickets.length + 1) {
      results.push([...result]);
      return;
    }

    if (!copyObj[from] || !copyObj[from].length) {
      return;
    }

    for (let i = 0; i < copyObj[from].length; i += 1) {
      const to = copyObj[from].pop();

      result.push(to);
      dfs(copyObj, to);
      result.pop();
      copyObj[from].unshift(to);
    }
  }

  dfs(obj, "ICN");
  return results.pop()
}