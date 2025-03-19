class Solution:
    def minOperations(self, nums: list[int]) -> int:
        n = len(nums)
        cnt = 0
        i = 2
        while i < n:
            if nums[i - 2] == 0:
                nums[i - 2] ^= 1
                nums[i - 1] ^= 1
                nums[i] ^= 1
                cnt += 1
            i += 1
        if 0 in nums:
            return -1
        return cnt