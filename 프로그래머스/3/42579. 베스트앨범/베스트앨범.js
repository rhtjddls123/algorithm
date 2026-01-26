function solution(genres, plays) {
  const genresPlays = {};
  const dup = {};
  genres.forEach((v, i) => {
    genresPlays[v] = genresPlays[v] ? genresPlays[v] + plays[i] : plays[i];
  });

  return genres
    .map((v, i) => ({ genre: v, idx: i, play: plays[i] }))
    .sort(
      (a, b) =>
        genresPlays[b.genre] - genresPlays[a.genre] ||
        b.play - a.play ||
        a.idx - b.idx,
    )
    .filter((v) => {
      if (dup[v.genre] >= 2) return false;
      dup[v.genre] = dup[v.genre] ? dup[v.genre] + 1 : 1;
      return true;
    })
    .map((v) => v.idx);
}