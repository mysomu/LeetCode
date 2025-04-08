class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        # c = 0
        # while len(list(set(nums)))!=len(nums):
        #     nums = nums[3:]
        #     c+=1
        # return c
        seen = set()
        for i in range(len(nums) - 1,  -1, -1):
            if nums[i] in seen:
                return i // 3 + 1
            seen.add(nums[i])
        return 0