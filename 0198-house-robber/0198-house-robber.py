# Using Memoization
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [-1] * len(nums)
        return self.memoiz(0, nums, dp)
    
    def memoiz(self, i, nums, dp):
        # Base case
        if i >= len(nums):
            return 0
        
        # Already computed
        if dp[i] != -1:
            return dp[i]
        
        # Take current house
        take = nums[i] + self.memoiz(i + 2, nums, dp)

        # Skip current house
        not_take = self.memoiz(i + 1, nums, dp)

        dp[i] = max(take, not_take)
        return dp[i]
