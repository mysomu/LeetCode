class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        ans = 0
        for i in nums:
            ans |= i
        return ans << (len(nums)-1)