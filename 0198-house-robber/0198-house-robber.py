class Solution:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        
        p1, p2 = nums[0], max(nums[0], nums[1])
        ans = max(p1, p2)
        
        for i in range(2, n):
            ans = max(p2, p1 + nums[i])
            p1, p2 = p2, ans
        
        return ans
