function solution(nums) {
    const set = new Set(nums);
    const pickCount = nums.length/2;
    return Math.min(set.size, pickCount)
}