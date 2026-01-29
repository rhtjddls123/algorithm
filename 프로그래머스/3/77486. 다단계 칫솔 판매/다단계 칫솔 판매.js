function solution(enroll, referral, seller, amount) {
  const enrollInfo = {};

  for (let i = 0; i < enroll.length; i += 1) {
    enrollInfo[enroll[i]] = { parent: referral[i], value: 0 };
  }

  for (let i = 0; i < seller.length; i += 1) {
    const sel = seller[i];
    const am = amount[i];

    const sellMoney = 100 * am;
    let parentMoney = Math.floor(sellMoney * 0.1);
    let myMoney = sellMoney - parentMoney;
    if (myMoney === 0) {
      myMoney = parentMoney;
      parentMoney = 0;
    }
    enrollInfo[sel].value += myMoney;
    let parent = enrollInfo[sel].parent;
    while (true) {
      if (parent === "-" || parentMoney === 0) break;
      const childMoney = parentMoney;
      parentMoney = Math.floor(childMoney * 0.1);
      myMoney = childMoney - parentMoney;

      if (myMoney === 0) {
        myMoney = parentMoney;
        parentMoney = 0;
      }
      enrollInfo[parent].value += myMoney;
      parent = enrollInfo[parent].parent;
    }
  }
  const result = Object.entries(enrollInfo).map(v=>v[1].value);
  return result
}
