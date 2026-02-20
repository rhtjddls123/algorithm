function solution(bridge_length, weight, truck_weights) {
  let time = 0;
  const bridge = Array.from({ length: bridge_length }).fill(0);
  let curW = 0;
  while (bridge.length) {
    time += 1;
    curW -= bridge.shift();

    if (truck_weights.length) {
      if (curW + truck_weights[0] <= weight) {
        const w = truck_weights.shift();
        bridge.push(w);
        curW += w;
      } else {
        bridge.push(0);
      }
    }
  }

  return time
}