function solution(begin, target, words) {
  if (!words.includes(target)) return 0;

  words = [begin, ...words];

  const wordDict = {};
  for (let i = 0; i < words.length; i += 1) {
    const word = words[i];
    for (let j = i + 1; j < words.length; j += 1) {
      const cWord = words[j];
      let cnt = 0;
      for (let k = 0; k < words[0].length; k += 1) {
        if (word[k] === cWord[k]) {
          cnt += 1;
        }
      }
      if (words[0].length - cnt === 1) {
        wordDict[word] = wordDict[word] ? [...wordDict[word], cWord] : [cWord];
        wordDict[cWord] = wordDict[cWord] ? [...wordDict[cWord], word] : [word];
      }
    }
  }

  console.log(wordDict);

  const queue = [[begin, 0]];
  const visited = {};

  while (queue.length) {
    const [v, depth] = queue.shift();
    visited[v] = true;
    for (const w of wordDict[v]) {
      if (!visited[w]) {
        queue.push([w, depth + 1]);
      }

      if (w === target) return depth + 1;
    }
  }

  console.log(wordDict);
}