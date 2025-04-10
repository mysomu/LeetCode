class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        if min(nums) < k:
            return -1

        mask = 0
        for x in nums:
            if x > k:
                mask |= 1 << x

        return bin(mask).count('1')