class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        return sum(i < j and nums[i] == nums[j] and (i * j) % k == 0
                   for i in range(len(nums)) for j in range(len(nums)))