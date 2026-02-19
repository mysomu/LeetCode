class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        dp = [0]*len(nums)

        dp[0]=nums[0]
        dp[1] = max(nums[0],nums[1])

        for i in range(2,len(nums)):
            include = dp[i-2]+nums[i]
            exclude = dp[i-1]
            dp[i] = max(include,exclude)
        
        return dp[-1]
