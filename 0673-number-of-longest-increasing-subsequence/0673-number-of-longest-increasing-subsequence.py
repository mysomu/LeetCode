class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        dp = [1] * len(nums)      
        cnt = [1] * len(nums)     
        
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    if dp[j] + 1 > dp[i]:
                        dp[i] = dp[j] + 1
                        cnt[i] = cnt[j]
                    elif dp[j] + 1 == dp[i]:
                        cnt[i] += cnt[j]
        
        maxi = max(dp)
        
        res = sum(cnt[i] for i in range(len(nums)) if dp[i] == maxi)
        return res
